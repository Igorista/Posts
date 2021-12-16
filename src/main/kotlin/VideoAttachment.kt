data class VideoAttachment(
    override val type: String,
    val video: Video
): Attachment("video")