package eu.kanade.tachiyomi.extension.en.hentaiforce

import eu.kanade.tachiyomi.multisrc.galleryadults.GalleryAdults
import eu.kanade.tachiyomi.source.Source
import eu.kanade.tachiyomi.source.SourceFactory

class HentaiForceSource : SourceFactory {
    override fun createSources(): List = listOf(
        HentaiForce("en", GalleryAdults.LANGUAGE_ENGLISH),
    )
}