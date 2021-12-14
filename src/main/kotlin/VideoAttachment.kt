data class VideoAttachment(
    override val type: String,
    val id: Int,
    val videoId: Int,
    val ownerId: Int,
    val userId: Int,
): Attachment("video")