package com.example.data.local

import com.example.data.model.AddressEntity
import com.example.data.model.BannerEntity
import com.example.data.model.CategoryEntity
import com.example.data.model.CouponEntity
import com.example.data.model.DealEntity
import com.example.data.model.NotificationEntity
import com.example.data.model.OrderEntity
import com.example.data.model.OrderItem
import com.example.data.model.ProductEntity
import com.example.data.model.ProductVariant
import com.example.data.model.StoreSettingsEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object SampleDataProvider {
    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    private val variantListType = Types.newParameterizedType(List::class.java, ProductVariant::class.java)
    private val variantAdapter = moshi.adapter<List<ProductVariant>>(variantListType)
    private val stringListType = Types.newParameterizedType(List::class.java, String::class.java)
    private val stringListAdapter = moshi.adapter<List<String>>(stringListType)
    private val orderItemListType = Types.newParameterizedType(List::class.java, OrderItem::class.java)
    private val orderItemAdapter = moshi.adapter<List<OrderItem>>(orderItemListType)

    fun getInitialCategories(): List<CategoryEntity> = listOf(
        CategoryEntity(id = 1, name = "Atta & Flour", hindiName = "आटा और आटा उत्पाद", iconName = "grain", displayOrder = 1),
        CategoryEntity(id = 2, name = "Rice & Grains", hindiName = "चावल और अनाज", iconName = "rice", displayOrder = 2),
        CategoryEntity(id = 3, name = "Dal & Pulses", hindiName = "दालें और फलियां", iconName = "spa", displayOrder = 3),
        CategoryEntity(id = 4, name = "Oil & Ghee", hindiName = "तेल और शुद्ध घी", iconName = "opacity", displayOrder = 4),
        CategoryEntity(id = 5, name = "Spices & Masala", hindiName = "मसाले और खड़े मसाले", iconName = "flare", displayOrder = 5),
        CategoryEntity(id = 6, name = "Biscuits & Bakery", hindiName = "बिस्कुट और बेकरी", iconName = "cookie", displayOrder = 6),
        CategoryEntity(id = 7, name = "Namkeen & Snacks", hindiName = "नमकीन और स्नैक्स", iconName = "fastfood", displayOrder = 7),
        CategoryEntity(id = 8, name = "Tea & Coffee", hindiName = "चाय और कॉफ़ी", iconName = "coffee", displayOrder = 8),
        CategoryEntity(id = 9, name = "Dairy & Eggs", hindiName = "दूध, दही और डेयरी", iconName = "egg", displayOrder = 9),
        CategoryEntity(id = 10, name = "Cold Drinks & Juices", hindiName = "कोल्ड ड्रिंक्स और जूस", iconName = "local_bar", displayOrder = 10),
        CategoryEntity(id = 11, name = "Personal Care", hindiName = "पर्सनल केयर", iconName = "sanitizer", displayOrder = 11),
        CategoryEntity(id = 12, name = "Home Cleaning", hindiName = "घर की सफाई", iconName = "cleaning_services", displayOrder = 12),
        CategoryEntity(id = 13, name = "Fruits & Vegetables", hindiName = "ताज़ा फल और सब्जियां", iconName = "nutrition", displayOrder = 13),
        CategoryEntity(id = 14, name = "Household Items", hindiName = "घरेलू आवश्यकताएं", iconName = "kitchen", displayOrder = 14),
        CategoryEntity(id = 15, name = "Other Grocery", hindiName = "अन्य किराना सामान", iconName = "storefront", displayOrder = 15)
    )

    fun getInitialProducts(): List<ProductEntity> {
        val attaVariants = listOf(
            ProductVariant(id = "1kg", name = "1 kg", mrp = 70.0, sellingPrice = 62.0, stock = 40, discountPercent = 11),
            ProductVariant(id = "2kg", name = "2 kg", mrp = 135.0, sellingPrice = 120.0, stock = 30, discountPercent = 11),
            ProductVariant(id = "5kg", name = "5 kg", mrp = 320.0, sellingPrice = 285.0, stock = 65, discountPercent = 11),
            ProductVariant(id = "10kg", name = "10 kg", mrp = 620.0, sellingPrice = 549.0, stock = 20, discountPercent = 11)
        )

        val riceVariants = listOf(
            ProductVariant(id = "1kg", name = "1 kg", mrp = 190.0, sellingPrice = 145.0, stock = 50, discountPercent = 24),
            ProductVariant(id = "5kg", name = "5 kg", mrp = 900.0, sellingPrice = 699.0, stock = 25, discountPercent = 22)
        )

        val dalVariants = listOf(
            ProductVariant(id = "500g", name = "500 g", mrp = 95.0, sellingPrice = 80.0, stock = 35, discountPercent = 16),
            ProductVariant(id = "1kg", name = "1 kg", mrp = 185.0, sellingPrice = 155.0, stock = 60, discountPercent = 16),
            ProductVariant(id = "2kg", name = "2 kg", mrp = 360.0, sellingPrice = 300.0, stock = 20, discountPercent = 17)
        )

        val gheeVariants = listOf(
            ProductVariant(id = "500ml", name = "500 ml", mrp = 330.0, sellingPrice = 295.0, stock = 40, discountPercent = 11),
            ProductVariant(id = "1L", name = "1 Litre", mrp = 650.0, sellingPrice = 580.0, stock = 45, discountPercent = 11)
        )

        return listOf(
            ProductEntity(
                id = 1,
                name = "Aashirvaad Sharbati Whole Wheat Atta",
                hindiName = "आशीर्वाद शरबती गेहूं का आटा",
                brand = "Aashirvaad",
                categoryId = 1,
                subcategory = "Atta",
                description = "100% pure whole wheat grain ground to perfection. Soft, nutritious rotis that stay fluffy for hours. Rich in dietary fiber and essential minerals directly sourced from selected MP wheat fields.",
                imagesJson = stringListAdapter.toJson(listOf("prod_wheat_atta")),
                mrp = 320.0,
                sellingPrice = 285.0,
                discountPercent = 11,
                discountAmount = 35.0,
                unit = "5 kg",
                stockQuantity = 65,
                minStockAlert = 5,
                sku = "ATT-AASH-5K",
                barcode = "8901030382901",
                isActive = true,
                isFeatured = true,
                isBestSeller = true,
                isNewArrival = false,
                dealBadge = "11% OFF",
                variantsJson = variantAdapter.toJson(attaVariants),
                salesCount = 142
            ),
            ProductEntity(
                id = 2,
                name = "India Gate Basmati Rice Rozzana",
                hindiName = "इंडिया गेट बासमती चावल रोज़ाना",
                brand = "India Gate",
                categoryId = 2,
                subcategory = "Basmati Rice",
                description = "Aromatic aged long grain basmati rice, ideal for everyday biryani, pulao and steamed rice. Pearl white grains with authentic aroma.",
                imagesJson = stringListAdapter.toJson(listOf("prod_basmati_rice")),
                mrp = 190.0,
                sellingPrice = 145.0,
                discountPercent = 24,
                discountAmount = 45.0,
                unit = "1 kg",
                stockQuantity = 50,
                minStockAlert = 5,
                sku = "RICE-IG-1K",
                barcode = "8901537001024",
                isActive = true,
                isFeatured = true,
                isBestSeller = true,
                isNewArrival = true,
                dealBadge = "Super Deal",
                variantsJson = variantAdapter.toJson(riceVariants),
                salesCount = 98
            ),
            ProductEntity(
                id = 3,
                name = "Tata Sampann Unpolished Toor Dal",
                hindiName = "टाटा सम्पन्न अनपॉलिश तुअर दाल",
                brand = "Tata Sampann",
                categoryId = 3,
                subcategory = "Toor Dal",
                description = "Nutrient rich unpolished Arhar / Toor dal with natural wholesome goodness, rich in plant protein. Cleaned and hygienically packed.",
                imagesJson = stringListAdapter.toJson(listOf("")),
                mrp = 185.0,
                sellingPrice = 155.0,
                discountPercent = 16,
                discountAmount = 30.0,
                unit = "1 kg",
                stockQuantity = 60,
                minStockAlert = 5,
                sku = "DAL-TATA-1K",
                barcode = "8901058852370",
                isActive = true,
                isFeatured = true,
                isBestSeller = true,
                isNewArrival = false,
                dealBadge = "Save ₹30",
                variantsJson = variantAdapter.toJson(dalVariants),
                salesCount = 82
            ),
            ProductEntity(
                id = 4,
                name = "Fortune Sunlite Refined Sunflower Oil",
                hindiName = "फॉर्च्यून सनलाइट रिफाइंड तेल",
                brand = "Fortune",
                categoryId = 4,
                subcategory = "Edible Oil",
                description = "Light and healthy cooking oil enriched with vitamins A & D. Low absorption formula keeps fried food light and crispy.",
                imagesJson = stringListAdapter.toJson(listOf("")),
                mrp = 165.0,
                sellingPrice = 138.0,
                discountPercent = 16,
                discountAmount = 27.0,
                unit = "1 L Pouch",
                stockQuantity = 40,
                minStockAlert = 5,
                sku = "OIL-FORT-1L",
                barcode = "8906007280145",
                isActive = true,
                isFeatured = true,
                isBestSeller = true,
                isNewArrival = false,
                dealBadge = "16% OFF",
                salesCount = 115
            ),
            ProductEntity(
                id = 5,
                name = "Amul Pure Cow Ghee Jar",
                hindiName = "अमूल शुद्ध गाय का देसी घी",
                brand = "Amul",
                categoryId = 4,
                subcategory = "Ghee",
                description = "Golden granular pure cow ghee made from fresh cream. Traditional rich aroma and taste, ideal for rotis, dal tadka, and traditional sweets.",
                imagesJson = stringListAdapter.toJson(listOf("")),
                mrp = 650.0,
                sellingPrice = 580.0,
                discountPercent = 11,
                discountAmount = 70.0,
                unit = "1 L",
                stockQuantity = 45,
                minStockAlert = 5,
                sku = "GHEE-AMUL-1L",
                barcode = "8901262010115",
                isActive = true,
                isFeatured = true,
                isBestSeller = true,
                isNewArrival = false,
                dealBadge = "Bestseller",
                variantsJson = variantAdapter.toJson(gheeVariants),
                salesCount = 76
            ),
            ProductEntity(
                id = 6,
                name = "MDH Deggi Mirch Powder",
                hindiName = "एमडीएच देगी मिर्च पाउडर",
                brand = "MDH",
                categoryId = 5,
                subcategory = "Spices",
                description = "Famous distinct Kashmiri red pepper blend that gives a vibrant natural red color and mild piquant taste to Indian curries.",
                imagesJson = stringListAdapter.toJson(listOf("")),
                mrp = 110.0,
                sellingPrice = 95.0,
                discountPercent = 14,
                discountAmount = 15.0,
                unit = "100 g",
                stockQuantity = 55,
                minStockAlert = 5,
                sku = "SPC-MDH-100",
                barcode = "8901091100018",
                isActive = true,
                isFeatured = false,
                isBestSeller = true,
                isNewArrival = false,
                dealBadge = "",
                salesCount = 64
            ),
            ProductEntity(
                id = 7,
                name = "Parle-G Gold Glucose Biscuit Family Pack",
                hindiName = "पारले-जी गोल्ड बिस्कुट पैक",
                brand = "Parle",
                categoryId = 6,
                subcategory = "Biscuits",
                description = "India's favorite glucose biscuit with milk and wheat goodness. Crispy and delicious tea-time companion for the whole family.",
                imagesJson = stringListAdapter.toJson(listOf("")),
                mrp = 35.0,
                sellingPrice = 28.0,
                discountPercent = 20,
                discountAmount = 7.0,
                unit = "1 kg Pack",
                stockQuantity = 80,
                minStockAlert = 8,
                sku = "BIS-PARLE-1K",
                barcode = "8901719102008",
                isActive = true,
                isFeatured = false,
                isBestSeller = true,
                isNewArrival = false,
                dealBadge = "20% OFF",
                salesCount = 190
            ),
            ProductEntity(
                id = 8,
                name = "Haldiram's Nagpur Aloo Bhujia",
                hindiName = "हल्दीराम आलू भुजिया",
                brand = "Haldiram's",
                categoryId = 7,
                subcategory = "Namkeen",
                description = "Crispy spicy potato and gram flour noodles seasoned with rich Indian spices. A timeless classic snack.",
                imagesJson = stringListAdapter.toJson(listOf("")),
                mrp = 110.0,
                sellingPrice = 89.0,
                discountPercent = 19,
                discountAmount = 21.0,
                unit = "400 g",
                stockQuantity = 60,
                minStockAlert = 6,
                sku = "SNK-HALD-400",
                barcode = "8904004400234",
                isActive = true,
                isFeatured = true,
                isBestSeller = true,
                isNewArrival = false,
                dealBadge = "Buy 1 Get 1",
                salesCount = 132
            ),
            ProductEntity(
                id = 9,
                name = "Tata Tea Gold Leaf Tea",
                hindiName = "टाटा टी गोल्ड पत्ती चाय",
                brand = "Tata Tea",
                categoryId = 8,
                subcategory = "Tea",
                description = "Exquisite blend of fine Assam CTC teas with 15% gently rolled long leaves for an irresistible aroma and full-bodied taste.",
                imagesJson = stringListAdapter.toJson(listOf("")),
                mrp = 340.0,
                sellingPrice = 289.0,
                discountPercent = 15,
                discountAmount = 51.0,
                unit = "500 g",
                stockQuantity = 45,
                minStockAlert = 5,
                sku = "TEA-TATA-500",
                barcode = "8901052002148",
                isActive = true,
                isFeatured = true,
                isBestSeller = true,
                isNewArrival = true,
                dealBadge = "15% OFF",
                salesCount = 105
            ),
            ProductEntity(
                id = 10,
                name = "Amul Taaza Homogenised Toned Milk",
                hindiName = "अमूल ताज़ा टोन्ड दूध",
                brand = "Amul",
                categoryId = 9,
                subcategory = "Milk",
                description = "Pasteurized toned milk with 3.0% fat and 8.5% SNF. Excellent source of calcium, protein and vitamins.",
                imagesJson = stringListAdapter.toJson(listOf("")),
                mrp = 28.0,
                sellingPrice = 27.0,
                discountPercent = 4,
                discountAmount = 1.0,
                unit = "500 ml",
                stockQuantity = 75,
                minStockAlert = 10,
                sku = "DRY-AMUL-500",
                barcode = "8901262010016",
                isActive = true,
                isFeatured = false,
                isBestSeller = true,
                isNewArrival = false,
                dealBadge = "Fresh",
                salesCount = 220
            ),
            ProductEntity(
                id = 11,
                name = "Coca-Cola Original Taste Bottle",
                hindiName = "कोका-कोला ओरिजिनल",
                brand = "Coca-Cola",
                categoryId = 10,
                subcategory = "Cold Drinks",
                description = "Classic refreshing fizzy cola drink, best served chilled for family celebrations, meals and parties.",
                imagesJson = stringListAdapter.toJson(listOf("")),
                mrp = 95.0,
                sellingPrice = 79.0,
                discountPercent = 17,
                discountAmount = 16.0,
                unit = "2.25 L",
                stockQuantity = 30,
                minStockAlert = 5,
                sku = "CD-COKE-225",
                barcode = "8901764012211",
                isActive = true,
                isFeatured = false,
                isBestSeller = false,
                isNewArrival = true,
                dealBadge = "Party Pack",
                salesCount = 54
            ),
            ProductEntity(
                id = 12,
                name = "Dettol Liquid Handwash Refill",
                hindiName = "डेटोल लिक्विड हैंडवॉश रिफिल",
                brand = "Dettol",
                categoryId = 11,
                subcategory = "Handwash",
                description = "Germ protection with added moisturizers. Dermatologically tested formula to protect your family's hands from illness causing germs.",
                imagesJson = stringListAdapter.toJson(listOf("")),
                mrp = 99.0,
                sellingPrice = 79.0,
                discountPercent = 20,
                discountAmount = 20.0,
                unit = "750 ml",
                stockQuantity = 50,
                minStockAlert = 5,
                sku = "PC-DETT-750",
                barcode = "8901396112211",
                isActive = true,
                isFeatured = false,
                isBestSeller = true,
                isNewArrival = false,
                dealBadge = "20% OFF",
                salesCount = 89
            ),
            ProductEntity(
                id = 13,
                name = "Surf Excel Quick Wash Detergent Powder",
                hindiName = "सर्फ एक्सेल क्विक वॉश डिटर्जेंट",
                brand = "Surf Excel",
                categoryId = 12,
                subcategory = "Laundry",
                description = "Advanced stain removal power that dissolves easily in water, removes tough stains from clothes while keeping fabric bright.",
                imagesJson = stringListAdapter.toJson(listOf("")),
                mrp = 215.0,
                sellingPrice = 178.0,
                discountPercent = 17,
                discountAmount = 37.0,
                unit = "1 kg",
                stockQuantity = 40,
                minStockAlert = 5,
                sku = "CLN-SURF-1K",
                barcode = "8901030382222",
                isActive = true,
                isFeatured = true,
                isBestSeller = true,
                isNewArrival = false,
                dealBadge = "17% OFF",
                salesCount = 110
            ),
            ProductEntity(
                id = 14,
                name = "Fresh Nashik Red Onions",
                hindiName = "ताज़ा नासिक लाल प्याज",
                brand = "Farm Fresh",
                categoryId = 13,
                subcategory = "Vegetables",
                description = "Crisp, pungent red onions sourced fresh from certified farms. Essential for daily Indian gravies, salads and cooking.",
                imagesJson = stringListAdapter.toJson(listOf("")),
                mrp = 45.0,
                sellingPrice = 32.0,
                discountPercent = 29,
                discountAmount = 13.0,
                unit = "1 kg",
                stockQuantity = 100,
                minStockAlert = 10,
                sku = "VEG-ONION-1K",
                barcode = "8900000000014",
                isActive = true,
                isFeatured = true,
                isBestSeller = true,
                isNewArrival = true,
                dealBadge = "Fresh Farm",
                salesCount = 260
            ),
            ProductEntity(
                id = 15,
                name = "Vim Dishwash Gel Lemon Refill Pouch",
                hindiName = "विम डिशवॉश जेल नींबू",
                brand = "Vim",
                categoryId = 12,
                subcategory = "Dishwash",
                description = "Power of 100 lemons. 1 spoon of Vim gel removes the toughest grease from utensils effortlessly leaving a refreshing lemon fragrance.",
                imagesJson = stringListAdapter.toJson(listOf("")),
                mrp = 135.0,
                sellingPrice = 110.0,
                discountPercent = 19,
                discountAmount = 25.0,
                unit = "750 ml",
                stockQuantity = 45,
                minStockAlert = 5,
                sku = "CLN-VIM-750",
                barcode = "8901030382333",
                isActive = true,
                isFeatured = false,
                isBestSeller = true,
                isNewArrival = false,
                dealBadge = "Save ₹25",
                salesCount = 85
            )
        )
    }

    fun getInitialBanners(): List<BannerEntity> = listOf(
        BannerEntity(
            id = 1,
            title = "Majri Grocery Grand Deals",
            subtitle = "Up to 30% OFF on daily pantry & kitchen staples",
            buttonText = "Shop Deals",
            imageUri = "banner_deals_festival",
            linkType = "DEAL",
            linkTarget = "1",
            displayOrder = 1,
            isActive = true
        ),
        BannerEntity(
            id = 2,
            title = "Fresh Farm Produce Daily",
            subtitle = "Farm-fresh vegetables, dairy and organic pulses",
            buttonText = "Explore Fresh",
            imageUri = "banner_fresh_groceries",
            linkType = "CATEGORY",
            linkTarget = "13",
            displayOrder = 2,
            isActive = true
        )
    )

    fun getInitialDeals(): List<DealEntity> = listOf(
        DealEntity(
            id = 1,
            title = "Mega Pantry Savings Sale",
            hindiTitle = "मेगा राशन बचत सेल",
            description = "Get flat 15% to 25% discount on whole wheat atta, basmati rice, pulses, and ghee.",
            bannerUri = "banner_deals_festival",
            dealType = "PERCENTAGE",
            discountPercent = 20,
            discountAmount = 0.0,
            minOrderValue = 500.0,
            maxDiscount = 150.0,
            startDate = "01 Sep 2026",
            endDate = "30 Sep 2026",
            isActive = true
        ),
        DealEntity(
            id = 2,
            title = "Weekend Snacks & Namkeen Special",
            hindiTitle = "वीकेंड स्नैक्स स्पेशल",
            description = "Buy 1 Get 1 Free on selected Haldiram's and Bikaji snacks.",
            bannerUri = "banner_fresh_groceries",
            dealType = "BOGO",
            discountPercent = 50,
            discountAmount = 0.0,
            minOrderValue = 300.0,
            maxDiscount = 100.0,
            startDate = "01 Sep 2026",
            endDate = "30 Sep 2026",
            isActive = true
        ),
        DealEntity(
            id = 3,
            title = "Flat ₹50 OFF on Daily Essentials",
            hindiTitle = "फ्लैट ₹50 की छूट",
            description = "Enjoy ₹50 instant discount on orders above ₹600 using coupon MAJRI50.",
            bannerUri = "",
            dealType = "FLAT",
            discountPercent = 0,
            discountAmount = 50.0,
            minOrderValue = 600.0,
            maxDiscount = 50.0,
            startDate = "01 Sep 2026",
            endDate = "31 Dec 2026",
            isActive = true
        )
    )

    fun getInitialCoupons(): List<CouponEntity> = listOf(
        CouponEntity(
            id = 1,
            code = "MAJRI50",
            description = "Flat ₹50 OFF on orders above ₹600",
            discountType = "FLAT",
            discountValue = 50.0,
            minOrderValue = 600.0,
            maxDiscount = 50.0,
            expiryDate = "31 Dec 2026",
            usageLimit = 100,
            isActive = true
        ),
        CouponEntity(
            id = 2,
            code = "WELCOME10",
            description = "10% OFF on your first grocery order up to ₹100",
            discountType = "PERCENTAGE",
            discountValue = 10.0,
            minOrderValue = 350.0,
            maxDiscount = 100.0,
            expiryDate = "31 Dec 2026",
            usageLimit = 500,
            isActive = true
        ),
        CouponEntity(
            id = 3,
            code = "FESTIVAL20",
            description = "20% OFF festive grocery discount up to ₹150",
            discountType = "PERCENTAGE",
            discountValue = 20.0,
            minOrderValue = 800.0,
            maxDiscount = 150.0,
            expiryDate = "30 Nov 2026",
            usageLimit = 50,
            isActive = true
        )
    )

    fun getInitialNotifications(): List<NotificationEntity> = listOf(
        NotificationEntity(
            id = 1,
            title = "Welcome to Majri Grocery Store!",
            message = "Order daily groceries with fast home delivery. Use code WELCOME10 for 10% off.",
            type = "PROMOTION",
            timestamp = System.currentTimeMillis() - 86400000L,
            isRead = false
        ),
        NotificationEntity(
            id = 2,
            title = "Today's Farm Fresh Arrival",
            message = "Fresh Nashik red onions and farm potatoes arrived today at discounted rates!",
            type = "DEAL",
            timestamp = System.currentTimeMillis() - 3600000L * 4,
            isRead = false
        )
    )

    fun getInitialAddresses(): List<AddressEntity> = listOf(
        AddressEntity(
            id = 1,
            label = "Home",
            recipientName = "Kapil Sharma",
            phone = "+91 98765 12345",
            streetAddress = "House No. 142, Street 3, Near Shiv Temple, Majri",
            landmark = "Opposite Community Park",
            pincode = "134109",
            isDefault = true
        ),
        AddressEntity(
            id = 2,
            label = "Work",
            recipientName = "Kapil Sharma",
            phone = "+91 98765 12345",
            streetAddress = "Shop 12, Main Market, Majri",
            landmark = "Near State Bank",
            pincode = "134109",
            isDefault = false
        )
    )

    fun getInitialOrders(): List<OrderEntity> {
        val sampleItems1 = listOf(
            OrderItem(productId = 1, productName = "Aashirvaad Sharbati Atta", brand = "Aashirvaad", variantName = "5 kg", quantity = 1, unitPrice = 285.0, mrp = 320.0, imageUri = "prod_wheat_atta"),
            OrderItem(productId = 2, productName = "India Gate Basmati Rice", brand = "India Gate", variantName = "1 kg", quantity = 2, unitPrice = 145.0, mrp = 190.0, imageUri = "prod_basmati_rice")
        )
        val sampleItems2 = listOf(
            OrderItem(productId = 5, productName = "Amul Pure Cow Ghee Jar", brand = "Amul", variantName = "1 L", quantity = 1, unitPrice = 580.0, mrp = 650.0, imageUri = ""),
            OrderItem(productId = 8, productName = "Haldiram's Aloo Bhujia", brand = "Haldiram's", variantName = "400 g", quantity = 2, unitPrice = 89.0, mrp = 110.0, imageUri = "")
        )

        return listOf(
            OrderEntity(
                id = 1,
                orderNumber = "MGS-2026-1082",
                customerName = "Kapil Sharma",
                customerPhone = "+91 98765 12345",
                deliveryAddress = "House No. 142, Street 3, Near Shiv Temple, Majri",
                landmark = "Opposite Community Park",
                pincode = "134109",
                subtotal = 575.0,
                discount = 50.0,
                deliveryCharge = 0.0,
                finalAmount = 525.0,
                paymentMethod = "Cash on Delivery",
                paymentStatus = "Pending",
                orderStatus = "Out for Delivery",
                orderDate = System.currentTimeMillis() - 7200000L,
                notes = "Please deliver before 6 PM.",
                itemsJson = orderItemAdapter.toJson(sampleItems1)
            ),
            OrderEntity(
                id = 2,
                orderNumber = "MGS-2026-1074",
                customerName = "Pooja Verma",
                customerPhone = "+91 98123 45678",
                deliveryAddress = "Flat 4B, Green Meadows, Majri Road",
                landmark = "Near Water Tank",
                pincode = "134109",
                subtotal = 758.0,
                discount = 75.0,
                deliveryCharge = 0.0,
                finalAmount = 683.0,
                paymentMethod = "UPI",
                paymentStatus = "Completed",
                orderStatus = "Delivered",
                orderDate = System.currentTimeMillis() - 86400000L * 2,
                notes = "Delivered successfully.",
                itemsJson = orderItemAdapter.toJson(sampleItems2)
            )
        )
    }

    val initialStoreSettings = StoreSettingsEntity(
        id = 1,
        storeName = "Majri Grocery Store",
        hindiStoreName = "माजरी किराना स्टोर",
        phone = "+91 98765 43210",
        address = "Main Market, Majri, Sector 1, Pin 134109",
        deliveryCharge = 30.0,
        freeDeliveryThreshold = 499.0,
        minOrderValue = 99.0,
        openingHours = "7:00 AM - 10:00 PM",
        deliveryRadius = "5 km",
        gstNumber = "06ABCDE1234F1Z5",
        allowCod = true,
        allowUpi = true,
        allowOnline = true
    )
}
