package fhnw.emoba.modules.module04.beers.data

import fhnw.emoba.R

object Repository {
    //todo: Beer implementieren, so dass die Kommentare entfernt werden koennen (ohne Compile-Fehler)

    val beers = listOf(
        Beer(
            title = "Blonde Ale",
            overview = "One of the most approachable styles, a golden or blonde ale is an easy-drinking beer that is visually...",
            voteAverage = 5.3,
            imageId = R.drawable.blonde_ale,
            link = "https://www.craftbeer.com/styles/blonde-ale"
        ),
        Beer(
            title = "Chocolate Beer",
            overview = "Few flavors are as universally celebrated as chocolate. From ancient civilizations who drank fermented...",
            voteAverage = 4.7,
            imageId = R.drawable.chocolate_beer,
            link = "https://www.craftbeer.com/styles/chocolate_beer"
        ),
        Beer(
            title = "Coffee Beer",
            overview = "If you had to combine two beverages that Americans love, you would have coffee beer. Craft breweries...",
            voteAverage = 4.5,
            imageId = R.drawable.coffee_beer,
            link = "https://www.craftbeer.com/styles/coffee_beer"
        ),
        Beer(
            title = "English-Style Bitter",
            overview = "The English-style bitter is a very sessionable, lower-alcohol, malt-driven style. Broad style description...",
            voteAverage = 5.6,
            imageId = R.drawable.english_style_bitter,
            link = "https://www.craftbeer.com/styles/english-style-bitter"
        ),
        Beer(
            title = "English-Style Brown Ale",
            overview = "A bona fide English beer classic, English-style brown ale is easily one of the most iconic beer styles....",
            voteAverage = 6.2,
            imageId = R.drawable.english_style_brown_ale,
            link = "https://www.craftbeer.com/styles/english-style-brown-ale"
        ),
        Beer(
            title = "English-Style Brown Porter",
            overview = "The English-style brown porter has no roasted barley or strong burnt/black malt character. Low to medium...",
            voteAverage = 7.2,
            imageId = R.drawable.english_style_brown_porter,
            link = "https://www.craftbeer.com/styles/english-style-brown-porter"
        ),
        Beer(
            title = "English-Style IPA",
            overview = "Strong, bitter and completely misunderstood, the English India pale ale (or English IPA) bridges the...",
            voteAverage = 6.7,
            imageId = R.drawable.english_style_india_pale_ale,
            link = "https://www.craftbeer.com/styles/english-style-india-pale-ale"
        ),
        Beer(
            title = "English-Style Oatmeal Stout",
            overview = "The addition of oatmeal adds a smooth, rich body to the oatmeal stout. This beer style is dark brown...",
            voteAverage = 7.5,
            imageId = R.drawable.english_style_oatmeal_stout,
            link = "https://www.craftbeer.com/styles/english-style-oatmeal-stout"
        ),
        Beer(
            title = "English-Style Old Ale",
            overview = "A distinctive quality of these ales is that their yeast undergoes an aging process (often for years)...",
            voteAverage = 6.5,
            imageId = R.drawable.english_style_old_ale,
            link = "https://www.craftbeer.com/styles/english-style-old-ale"
        ),
        Beer(
            title = "English-Style Pale Ale (ESB)",
            overview = "ESB stands for 'extra special bitter.' This style is known for its balance and the interplay between...",
            voteAverage = 5.9,
            imageId = R.drawable.english_style_pale_ale_esb,
            link = "https://www.craftbeer.com/styles/english-style-pale-ale-esb"
        ),
        Beer(
            title = "English-Style Sweet Stout (Milk Stout)",
            overview = "Sweet stout, also referred to as cream stout or milk stout, is black in color. Malt sweetness, chocolate...",
            voteAverage = 5.7,
            imageId = R.drawable.english_style_sweet_stout_milk_stout,
            link = "https://www.craftbeer.com/styles/english-style-sweet-stout-milk-stout"
        ),
        Beer(
            title = "German-Style Bock",
            overview = "Also called 'heller bock' (meaning 'pale bock'), the German-style Maibock is paler in color and more...",
            voteAverage = 7.2,
            imageId = R.drawable.german_style_bock,
            link = "https://www.craftbeer.com/styles/german-style-bock"
        ),
        Beer(
            title = "German-Style Altbier",
            overview = "Originally from the Düsseldorf area of Germany, the German-Style Altbier strikes a balance between...",
            voteAverage = 6.9,
            imageId = R.drawable.german_style_brownaltbier,
            link = "https://www.craftbeer.com/styles/german-style-brownaltbier"
        ),
        Beer(
            title = "German-Style Doppelbock",
            overview = "'Doppel' meaning 'double,' this style is a bigger and stronger version of the lower-gravity German-style...",
            voteAverage = 6.1,
            imageId = R.drawable.german_style_doppelbock,
            link = "https://www.craftbeer.com/styles/german-style-doppelbock"
        ),
        Beer(
            title = "German-Style Dunkel",
            overview = "The German-style dunkel is a bottom-fermented lager style beer. The word 'dunkel' is German for 'dark,'...",
            voteAverage = 7.2,
            imageId = R.drawable.german_style_dunkel,
            link = "https://www.craftbeer.com/styles/german-style-dunkel"
        ),
        Beer(
            title = "German-Style Dunkelweizen",
            overview = "The German-style Dunkelweizen can be considered a cross between a German-style dunkel and a hefeweizen....",
            voteAverage = 7.8,
            imageId = R.drawable.german_style_dunkelweizen,
            link = "https://www.craftbeer.com/styles/german-style-dunkelweizen"
        ),
        Beer(
            title = "German-Style Hefeweizen",
            overview = "Arguably one of the most recognizable beer styles, the German-style hefeweizen offers a striking beer...",
            voteAverage = 7.5,
            imageId = R.drawable.german_style_hefeweizen,
            link = "https://www.craftbeer.com/styles/german-style-hefeweizen"
        ),
        Beer(
            title = "German-Style Helles",
            overview = "A beer for beer lovers, the German-style helles is a malt accented lager beer that balances a pleasant...",
            voteAverage = 7.2,
            imageId = R.drawable.german_style_helles,
            link = "https://www.craftbeer.com/styles/german-style-helles"
        ),
        Beer(
            title = "German-Style Kolsch",
            overview = "Crisp, delicate and oh-so-drinkable, the German-style Kolsch is a beer hybrid, meaning that its production...",
            voteAverage = 6.8,
            imageId = R.drawable.german_style_kolsch,
            link = "https://www.craftbeer.com/styles/german-style-kolsch"
        ),
        Beer(
            title = "German-Style Pilsner",
            overview = "Quite possibly the most iconic beer style in modern history, the pilsner captured the attention of beer...",
            voteAverage = 6.5,
            imageId = R.drawable.german_style_pilsener,
            link = "https://www.craftbeer.com/styles/german-style-pilsener"
        ),
        Beer(
            title = "German-Style Schwarzbier",
            overview = "Sometimes called black lagers, they may remind some of German-style dunkels, but schwarzbiers are drier,...",
            voteAverage = 6.7,
            imageId = R.drawable.german_style_schwarzbier,
            link = "https://www.craftbeer.com/styles/german-style-schwarzbier"
        ),
        Beer(
            title = "Irish-Style Dry Stout",
            overview = "Dry stout is black beer with a dry-roasted character thanks to the use of roasted barley. The emphasis...",
            voteAverage = 6.6,
            imageId = R.drawable.irish_style_dry_stout,
            link = "https://www.craftbeer.com/styles/irish-style-dry-stout"
        ),
        Beer(
            title = "New England IPA",
            overview = "Emphasizing hop aroma and flavor without bracing bitterness, the New England IPA leans heavily on late...",
            voteAverage = 7.0,
            imageId = R.drawable.new_england_ipa,
            link = "https://www.craftbeer.com/styles/new-england-ipa"
        ),
        Beer(
            title = "Robust Porter",
            overview = "The Robust Porter features more bitter and roasted malt flavor than a brown porter, but not quite as...",
            voteAverage = 7.2,
            imageId = R.drawable.robust_porter,
            link = "https://www.craftbeer.com/styles/robust-porter"
        ),
        Beer(
            title = "Scottish-Style Ale",
            overview = "Scottish-style ales vary depending on strength and flavor, but in general retain a malt-forward character...",
            voteAverage = 6.5,
            imageId = R.drawable.scottish_style_ale,
            link = "https://www.craftbeer.com/styles/scottish-style-ale"
        ),
        Beer(
            title = "Vienna-Style Lager",
            overview = "Vienna Lager ranges from copper to reddish brown in color. The beer is characterized by malty aroma and...",
            voteAverage = 6.7,
            imageId = R.drawable.vienna_style_lager,
            link = "https://www.craftbeer.com/styles/vienna-style-lager"
        )
    )

}