package app.vercel.lcsanimelist.data.local.converter

import androidx.room.TypeConverter
import app.vercel.lcsanimelist.domain.model.PersonalStage
import app.vercel.lcsanimelist.domain.model.PersonalTier
import java.time.LocalDate

class GenreConverter {
    @TypeConverter
    fun fromGenreList(genres: List<String>): String {
        return genres.joinToString(",")
    }

    @TypeConverter
    fun toGenreList(genres: String): List<String> {
        return if (genres.isBlank()) emptyList() else genres.split(",")
    }
}

class LocalDateConverter {
    @TypeConverter
    fun fromLocalDate(date: LocalDate?): String? {
        return date?.toString()
    }

    @TypeConverter
    fun toLocalDate(date: String?): LocalDate? {
        return date?.let { LocalDate.parse(it) }
    }
}

class EnumConverter {
    @TypeConverter
    fun fromPersonalStage(stage: PersonalStage): Int {
        return stage.ordinal
    }

    @TypeConverter
    fun toPersonalStage(stage: Int): PersonalStage {
        return PersonalStage.entries[stage]
    }

    @TypeConverter
    fun fromPersonalTier(tier: PersonalTier?): Int? {
        return tier?.ordinal
    }

    @TypeConverter
    fun toPersonalTier(tier: Int?): PersonalTier? {
        return tier?.let { PersonalTier.entries[it] }
    }
}