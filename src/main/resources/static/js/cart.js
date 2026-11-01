// ── Cart stored in localStorage ──────────────────────────────────────────────

const Cart = {
  get() {
    return JSON.parse(localStorage.getItem('stepup_cart') || '[]');
  },
  save(items) {
    localStorage.setItem('stepup_cart', JSON.stringify(items));
    Cart.updateBadge();
  },
  add(product, size, color, qty = 1) {
    const items = Cart.get();
    const key = `${product.id}_${size}_${color}`;
    const existing = items.find(i => i.key === key);
    if (existing) {
      existing.qty += qty;
    } else {
      items.push({ key, id: product.id, name: product.name, brand: product.brand,
        price: product.price, imageUrl: product.imageUrl, size, color, qty });
    }
    Cart.save(items);
  },
  remove(key) {
    Cart.save(Cart.get().filter(i => i.key !== key));
  },
  updateQty(key, qty) {
    const items = Cart.get();
    const item = items.find(i => i.key === key);
    if (item) { item.qty = qty; Cart.save(items); }
  },
  total() {
    return Cart.get().reduce((sum, i) => sum + i.price * i.qty, 0);
  },
  count() {
    return Cart.get().reduce((sum, i) => sum + i.qty, 0);
  },
  clear() {
    localStorage.removeItem('stepup_cart');
    Cart.updateBadge();
  },
  updateBadge() {
    const badge = document.getElementById('cart-count');
    if (badge) badge.textContent = Cart.count();
  }
};

// ── Toast notification ────────────────────────────────────────────────────────
function showToast(msg, type = 'success') {
  let toast = document.getElementById('toast');
  if (!toast) {
    toast = document.createElement('div');
    toast.id = 'toast';
    toast.className = 'toast';
    document.body.appendChild(toast);
  }
  toast.className = `toast ${type}`;
  toast.innerHTML = `<span>${type === 'success' ? '✓' : '✕'}</span> ${msg}`;
  toast.classList.add('show');
  setTimeout(() => toast.classList.remove('show'), 3000);
}

// ── Star rating renderer ──────────────────────────────────────────────────────
function renderStars(rating) {
  const full = Math.floor(rating);
  const half = rating % 1 >= 0.5;
  let s = '★'.repeat(full);
  if (half) s += '½';
  s += '☆'.repeat(5 - full - (half ? 1 : 0));
  return s;
}

// ── Format currency ───────────────────────────────────────────────────────────
function formatPrice(p) {
  return '₹' + p.toLocaleString('en-IN');
}

// ── Product card HTML ─────────────────────────────────────────────────────────
function productCardHTML(p) {
  const sizes = p.sizes.split(',');
  const isNew = p.id > 20;
  return `
    <div class="product-card">
      <div class="product-img-wrap">
        <img src="${p.imageUrl}" alt="${p.name}" loading="lazy" onerror="this.src='https://via.placeholder.com/400x300?text=Aurelia'">
        ${p.discountPercent > 0 ? `<span class="badge-discount">-${p.discountPercent}%</span>` : ''}
        ${isNew ? `<span class="badge-new">NEW</span>` : ''}
      </div>
      <div class="product-info">
        <div class="product-brand">${p.brand}</div>
        <div class="product-name">${p.name}</div>
        <div class="product-rating">
          <span class="stars">${renderStars(p.rating)}</span>
          <span class="rating-val">${p.rating}</span>
        </div>
        <div class="product-price">
          <span class="price-current">${formatPrice(p.price)}</span>
          ${p.originalPrice > p.price ? `<span class="price-original">${formatPrice(p.originalPrice)}</span>` : ''}
        </div>
        <div class="product-sizes">
          ${sizes.map(s => `<span class="size-chip">${s}</span>`).join('')}
        </div>
        <div class="product-actions">
          <button class="btn-cart" onclick="quickAddToCart(${p.id})">🛒 Add to Cart</button>
          <button class="btn-view" onclick="window.location.href='product.html?id=${p.id}'">👁</button>
        </div>
      </div>
    </div>`;
}

// ── Quick add (uses first size) ───────────────────────────────────────────────
async function quickAddToCart(productId) {
  const res = await fetch(`/api/products/${productId}`);
  const p = await res.json();
  const size = p.sizes.split(',')[0];
  const color = p.colors ? p.colors.split(',')[0] : '';
  Cart.add(p, size, color);
  showToast(`${p.name} added to cart!`);
}

// ── Init navbar cart badge ────────────────────────────────────────────────────
document.addEventListener('DOMContentLoaded', () => {
  Cart.updateBadge();

  // Hamburger menu
  const hamburger = document.querySelector('.hamburger');
  const navLinks = document.querySelector('.nav-links');
  if (hamburger && navLinks) {
    hamburger.addEventListener('click', () => navLinks.classList.toggle('open'));
  }

  // Global search in navbar
  const searchForm = document.getElementById('navbar-search');
  if (searchForm) {
    searchForm.addEventListener('submit', e => {
      e.preventDefault();
      const q = document.getElementById('navbar-search-input').value.trim();
      if (q) window.location.href = `shop.html?name=${encodeURIComponent(q)}`;
    });
  }
});
