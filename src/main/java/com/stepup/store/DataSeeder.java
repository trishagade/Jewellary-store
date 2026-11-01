package com.stepup.store;

import com.stepup.store.model.Product;
import com.stepup.store.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository repo;

    public DataSeeder(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        if (repo.count() > 0) return;

        // ── NECKLACES ──────────────────────────────────
        repo.save(new Product("Royal Kundan Necklace", "Tanishq", "Necklaces", 4999, 6499, 23,
                "16 in,18 in,20 in", "Gold,Rose Gold", 4.7, 25,
                "/images/necklace-1.svg",
                "Elegant kundan-inspired necklace with a statement stone. Perfect for weddings and festive evenings."));

        repo.save(new Product("Silver Lariat Chain", "Giva", "Necklaces", 3299, 3999, 18,
                "16 in,18 in,20 in", "Silver,White Gold", 4.5, 40,
                "/images/necklace-2.svg",
                "Delicate 925 sterling silver chain with a sparkling centre stone. Everyday luxury."));

        repo.save(new Product("Rose Gold Bead Necklace", "Zaveri Pearls", "Necklaces", 3799, 4499, 16,
                "16 in,18 in", "Rose Gold,Gold", 4.4, 35,
                "/images/necklace-3.svg",
                "Beaded rose-gold necklace with a teardrop gem. Light, graceful and easy to layer."));

        repo.save(new Product("Heirloom Choker", "Kalyan Jewellers", "Necklaces", 5499, 6999, 21,
                "14 in,16 in,18 in", "Gold,Antique Gold", 4.6, 20,
                "/images/necklace-4.svg",
                "Traditional choker with fine detailing. A timeless piece for special occasions."));


        // ── EARRINGS ──────────────────────────────────
        repo.save(new Product("Teardrop Jhumka Earrings", "Tanishq", "Earrings", 2799, 3499, 20,
                "One Size", "Gold,Ruby Red", 4.8, 50,
                "/images/earrings-1.svg",
                "Classic jhumka-style drop earrings with a gemstone finish. Lightweight and comfortable."));

        repo.save(new Product("Silver Drop Earrings", "Giva", "Earrings", 1799, 2199, 18,
                "One Size", "Silver,Blue", 4.5, 70,
                "/images/earrings-2.svg",
                "Sterling silver drop earrings with a shimmering stone. Perfect for office and parties."));

        repo.save(new Product("Rose Gold Dangle Earrings", "Pandora", "Earrings", 3199, 3999, 20,
                "One Size", "Rose Gold,Pink", 4.4, 45,
                "/images/earrings-3.svg",
                "Elegant dangle earrings in a blush rose-gold finish. A graceful everyday statement."));

        repo.save(new Product("Pearl Stud Drops", "Mia by Tanishq", "Earrings", 2499, 2999, 17,
                "One Size", "Silver,Pearl White", 4.3, 55,
                "/images/earrings-4.svg",
                "Soft pearl-finish drops with a polished silver setting. Timeless and understated."));


        // ── RINGS ──────────────────────────────────
        repo.save(new Product("Solitaire Gold Ring", "Tanishq", "Rings", 6999, 8499, 18,
                "6,7,8,9,10", "Gold,Rose Gold", 4.8, 30,
                "/images/ring-1.svg",
                "Classic solitaire ring with a brilliant centre stone. A perfect gift for engagements."));

        repo.save(new Product("Silver Gem Ring", "Giva", "Rings", 2199, 2699, 19,
                "6,7,8,9,10", "Silver,White Gold", 4.5, 60,
                "/images/ring-2.svg",
                "Sterling silver cocktail ring with a bold gemstone. Adjustable comfort fit."));

        repo.save(new Product("Rose Gold Promise Ring", "Pandora", "Rings", 3999, 4799, 17,
                "5,6,7,8,9", "Rose Gold,Gold", 4.6, 35,
                "/images/ring-3.svg",
                "Sleek rose-gold band topped with a sparkling stone. Romantic and modern."));

        repo.save(new Product("Emerald Cut Ring", "Malabar Gold", "Rings", 5499, 6999, 21,
                "6,7,8,9,10", "Gold,Green", 4.7, 25,
                "/images/ring-4.svg",
                "Gold ring set with an emerald-cut stone. Rich colour with a refined look."));


        // ── BRACELETS ──────────────────────────────────
        repo.save(new Product("Charm Chain Bracelet", "Pandora", "Bracelets", 3499, 4299, 19,
                "S,M,L", "Gold,Silver", 4.5, 45,
                "/images/bracelet-1.svg",
                "Dainty chain bracelet with a hanging charm. Adjustable clasp for a perfect fit."));

        repo.save(new Product("Silver Link Bracelet", "Giva", "Bracelets", 2499, 2999, 17,
                "S,M,L", "Silver,Rose Gold", 4.4, 55,
                "/images/bracelet-2.svg",
                "Polished sterling silver link bracelet with a gem charm. Light and elegant."));

        repo.save(new Product("Rose Gold Tennis Bracelet", "Zaveri Pearls", "Bracelets", 4299, 5199, 17,
                "S,M,L", "Rose Gold,Gold", 4.6, 30,
                "/images/bracelet-3.svg",
                "Sparkling bracelet with evenly set stones. Dress it up or wear it every day."));

        repo.save(new Product("Beaded Charm Bracelet", "Mia by Tanishq", "Bracelets", 1999, 2499, 20,
                "S,M,L", "Gold,Silver", 4.2, 65,
                "/images/bracelet-4.svg",
                "Delicate beaded bracelet with a drop charm. A sweet gift for any occasion."));


        // ── BANGLES ──────────────────────────────────
        repo.save(new Product("Gold Plated Bangle Set", "Kalyan Jewellers", "Bangles", 3799, 4599, 17,
                "2.4,2.6,2.8", "Gold,Antique Gold", 4.6, 40,
                "/images/bangle-1.svg",
                "Set of two gold-plated bangles with stone detailing. Traditional with a modern shine."));

        repo.save(new Product("Rose Gold Kada", "Malabar Gold", "Bangles", 4999, 5999, 17,
                "2.4,2.6,2.8", "Rose Gold,Gold", 4.5, 30,
                "/images/bangle-2.svg",
                "Chunky kada in a warm rose-gold finish. A strong statement for festive wear."));

        repo.save(new Product("Silver Oxidised Bangles", "Zaveri Pearls", "Bangles", 1999, 2499, 20,
                "2.4,2.6,2.8", "Silver,Oxidised", 4.3, 50,
                "/images/bangle-3.svg",
                "Stacked silver bangles with a vintage touch. Pairs well with ethnic and western outfits."));

        repo.save(new Product("Designer Stone Bangle", "Tanishq", "Bangles", 5999, 7199, 17,
                "2.4,2.6,2.8", "Gold,Ruby Red", 4.7, 25,
                "/images/bangle-4.svg",
                "Designer bangle studded with colourful stones. Crafted for weddings and celebrations."));


        // ── PENDANTS ──────────────────────────────────
        repo.save(new Product("Heart Gem Pendant", "Pandora", "Pendants", 2999, 3599, 17,
                "16 in,18 in", "Gold,Rose Gold", 4.6, 60,
                "/images/pendant-1.svg",
                "Elegant pendant with a hanging gemstone on a fine chain. A gift she will treasure."));

        repo.save(new Product("Silver Solitaire Pendant", "Giva", "Pendants", 2299, 2799, 18,
                "16 in,18 in", "Silver,White Gold", 4.5, 70,
                "/images/pendant-2.svg",
                "Sterling silver pendant with a single sparkling stone. Minimal and modern."));

        repo.save(new Product("Rose Gold Drop Pendant", "Mia by Tanishq", "Pendants", 3199, 3899, 18,
                "16 in,18 in", "Rose Gold,Gold", 4.4, 45,
                "/images/pendant-3.svg",
                "Teardrop pendant with a soft rose-gold shine. Easy to wear with any neckline."));

        repo.save(new Product("Birthstone Pendant", "Malabar Gold", "Pendants", 3599, 4299, 16,
                "16 in,18 in,20 in", "Silver,Gold", 4.3, 40,
                "/images/pendant-4.svg",
                "Personal birthstone pendant on a delicate chain. A meaningful everyday piece."));


        // ── ANKLETS ──────────────────────────────────
        repo.save(new Product("Silver Charm Anklet", "Giva", "Anklets", 1299, 1599, 19,
                "9 in,10 in,11 in", "Silver,Oxidised", 4.5, 80,
                "/images/anklet-1.svg",
                "Dainty silver anklet with tiny gem charms. Light enough to wear all day."));

        repo.save(new Product("Gold Plated Payal", "Kalyan Jewellers", "Anklets", 1799, 2199, 18,
                "9 in,10 in,11 in", "Gold,Antique Gold", 4.4, 65,
                "/images/anklet-2.svg",
                "Traditional gold-plated payal with fine charms. A festive favourite."));

        repo.save(new Product("Beach Chain Anklet", "Zaveri Pearls", "Anklets", 1499, 1799, 17,
                "9 in,10 in,11 in", "Silver,Blue", 4.3, 55,
                "/images/anklet-3.svg",
                "Slim chain anklet with sparkling drops. Perfect for summer and beach days."));

        repo.save(new Product("Rose Gold Bell Anklet", "Mia by Tanishq", "Anklets", 2199, 2699, 19,
                "9 in,10 in,11 in", "Rose Gold,Gold", 4.2, 45,
                "/images/anklet-4.svg",
                "Rose-gold anklet with delicate charms and an adjustable clasp."));
    }
}
