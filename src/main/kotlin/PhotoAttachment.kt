data  class PhotoAttachment(
    override val type: String,
    val id: Int,
    val photoId: Int,
    val ownerId: Int,
    val userId: Int
) : Attachment("photo") {
}