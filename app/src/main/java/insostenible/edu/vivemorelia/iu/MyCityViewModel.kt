package insostenible.edu.vivemorelia.iu

import androidx.lifecycle.ViewModel
import insostenible.edu.vivemorelia.data.MoreliaData
import insostenible.edu.vivemorelia.data.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        MyCityUiState(
            categories = MoreliaData.categories
        )
    )
    val uiState: StateFlow<MyCityUiState> = _uiState

    fun selectCategory(categoryId: Int) {
        _uiState.update {
            it.copy(
                currentCategoryId = categoryId,
                placesForCategory = MoreliaData.places.filter { p -> p.categoryId == categoryId }
            )
        }
    }

    fun selectPlace(place: Place) {
        _uiState.update {
            it.copy(currentPlace = place)
        }
    }
}
