package eu.kanade.tachiyomi.extension.en.hentaiforce

import eu.kanade.tachiyomi.multisrc.galleryadults.GalleryAdults
import eu.kanade.tachiyomi.multisrc.galleryadults.imgAttr
import org.jsoup.nodes.Element
import java.io.IOException

class HentaiForce(
    lang: String = "en",
    override val mangaLang: String = "en",
): GalleryAdults(
    "HentaiForce",
    "https://hentaiforce.net",
    lang = lang,
) {
    override val supportsLatest = true
    override val useIntermediateSearch: Boolean = true
    override val supportAdvancedSearch: Boolean = true
    override val supportSpeechless: Boolean = true

    override fun Element.mangaLang() = select("a:has(.thumb_flag)").attr("href")
        .removeSuffix("/").substringAfterLast("/")
        .let {
            // Include Speechless in search results
            if (it == LANGUAGE_SPEECHLESS) mangaLang
            else it
        }

    /* Details */
    override fun Element.getInfo(tag: String): String {
        return select("li:has(.tags_text:contains($tag:)) a.tag")
            .joinToString {
                val name = it.ownText()
                if (tag.contains(regexTag)) {
                    genres[name] = it.attr("href")
                        .removeSuffix("/").substringAfterLast('/')
                }
                listOf(
                        name,
                        it.select(".split_tag").text()
                        .trim().removePrefix("| "),
                    ).filter {
                        s - > s.isNotBlank()
                    }
                    .joinToString()
            }
    }

    override fun Element.getCover() = selectFirst(".left_cover img")?.imgAttr()
    override val mangaDetailInfoSelector = ".gallery_first"

    /* Pages */
    override val thumbnailSelector = ".gthumb"
    override val pageUri = "view"
}