package insostenible.edu.vivemorelia.data

import insostenible.edu.vivemorelia.R

object MoreliaData {

    val categories = listOf(
        Category(1, "Cafeterías", R.drawable.caf_icon),
        Category(2, "Parques", R.drawable.parque),
        Category(3, "Sitios Históricos", R.drawable.sitio),
        Category(4, "Las mejores Vistas", R.drawable.sitios_ver)
    )

    val places = listOf(
        // Cafeterías
        Place(
            id = 1,
            name = "Café La Lucha",
            description = "Café moderno con panadería artesanal y excelente ambiente.",
            address = "Bartolomé de Las Casas 342, Centro histórico de Morelia",
            imageRes = R.drawable.laluchacafe,
            categoryId = 1
        ),
        Place(
            id = 2,
            name = "Café Europa",
            description = "Café tradicional con postres y bebidas clásicas.",
            address = "Av. Francisco I. Madero Ote. 330",
            imageRes = R.drawable.caf_europa,
            categoryId = 1
        ),

        // Parques
        Place(
            id = 3,
            name = "Bosque Cuauhtémoc",
            description = "El parque más grande de Morelia, ideal para caminar y relajarte.",
            address = "Calzada Ventura Puente, Centro",
            imageRes = R.drawable.bosque_cuau,
            categoryId = 2
        ),

        // Historic sites
        Place(
            id = 4,
            name = "Catedral de Morelia",
            description = "Símbolo icónico de la ciudad con arquitectura barroca impresionante.",
            address = "Av. Madero Pte., Centro",
            imageRes = R.drawable.centromorelia,
            categoryId = 3
        ),

        // Lugares con bunas vistas
        Place(
            id = 5,
            name = "Mirador de Las Tarascas",
            description = "Vista panorámica del acueducto, las tarascas y la catedral.",
            address = "Av. Acueducto",
            imageRes = R.drawable.tarascas,
            categoryId = 4
        )
    )
}
