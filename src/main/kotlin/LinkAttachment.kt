data  class LinkAttachment(
    override val type: String,
    val link:Link
) : Attachment("link") {
}