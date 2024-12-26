package eu.kanade.tachiyomi.extension.all.hentaiforce

import eu.kanade.tachiyomi.multisrc.galleryadults.GalleryAdults
import eu.kanade.tachiyomi.source.Source
import eu.kanade.tachiyomi.source.SourceFactory

class HFFactory : SourceFactory {
    override fun createSources(): List<Source> = listOf(
        HentaiForce("en", GalleryAdults.LANGUAGE_ENGLISH),
        HentaiForce("ja", GalleryAdults.LANGUAGE_JAPANESE),
        HentaiForce("zh", GalleryAdults.LANGUAGE_CHINESE),
        HentaiForce("all", GalleryAdults.LANGUAGE_MULTI),
    )
}
