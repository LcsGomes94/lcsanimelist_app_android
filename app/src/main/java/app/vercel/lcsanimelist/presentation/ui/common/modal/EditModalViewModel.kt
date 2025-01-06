package app.vercel.lcsanimelist.presentation.ui.common.modal

import androidx.lifecycle.ViewModel
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.PersonalStage
import app.vercel.lcsanimelist.domain.model.PersonalTier
import app.vercel.lcsanimelist.presentation.ui.common.type.ModalActionType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

typealias OnConfirmCallback = (anime: Anime, action: ModalActionType) -> Unit

class EditModalViewModel() : ViewModel() {

    private val _currentAnimeBeingEdited = MutableStateFlow<Anime?>(null)
    val currentAnimeBeingEdited = _currentAnimeBeingEdited.asStateFlow()

    private val _isFavorite = MutableStateFlow<Boolean>(false)
    val isFavorite = _isFavorite.asStateFlow()

    private val _newStage = MutableStateFlow<PersonalStage?>(null)
    val newStage = _newStage.asStateFlow()
    private val _newTier = MutableStateFlow<PersonalTier?>(null)
    val newTier = _newTier.asStateFlow()
    private val _newPersonalNote = MutableStateFlow<String>("")
    val newPersonalNote = _newPersonalNote.asStateFlow()

    private var onConfirmCallback: OnConfirmCallback = { _, _ -> }

    fun openModal(
        anime: Anime,
        onConfirmCallback: OnConfirmCallback,
    ) {
        _isFavorite.value = anime.personalStage != null
        _newStage.value = anime.personalStage
        _newTier.value = anime.personalTier
        _newPersonalNote.value = anime.personalNote.orEmpty()
        this.onConfirmCallback = onConfirmCallback

        _currentAnimeBeingEdited.value = anime
    }

    fun closeModal() {
        _currentAnimeBeingEdited.value = null
    }

    fun onConfirmButtonClick() {
        currentAnimeBeingEdited.value?.let { anime ->
            if (_isFavorite.value) {
                val updatedAnime = anime.copy(
                    personalStage = _newStage.value ?: anime.personalStage,
                    personalTier = _newTier.value ?: anime.personalTier,
                    personalNote = _newPersonalNote.value.ifEmpty { null },
                )
                onConfirmCallback(updatedAnime, ModalActionType.UPDATE)
            } else {
                onConfirmCallback(anime, ModalActionType.DELETE)
            }
        }

        closeModal()
    }

    fun onFavoriteToggle() {
        _isFavorite.value = !_isFavorite.value
    }

}