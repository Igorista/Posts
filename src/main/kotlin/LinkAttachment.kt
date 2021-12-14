data  class LinkAttachment(
    override val type: String,
    val id: Int,
    val linkId: Int,
    val ownerId: Int,
    val userId: Int
) : Attachment("link") {
}