package insostenible.edu.vivemorelia.iu

import insostenible.edu.vivemorelia.data.Category
import insostenible.edu.vivemorelia.data.Place

data class MyCityUiState(
    val categories: List<Category> = emptyList(),
    val placesForCategory: List<Place> = emptyList(),
    val currentCategoryId: Int? = null,
    val currentPlace: Place? = null
)
