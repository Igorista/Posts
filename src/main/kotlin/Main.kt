fun main(args: Array<String>) {
    Attachments.attachAdd(VideoAttachment("video", Video(21, 12, 1, 12)))
    Attachments.attachAdd(AudioAttachment("audio", Audio(1, 2, 3, 4)))
    Attachments.attachAdd(LinkAttachment("link", Link(2, 2, 2, 2)))
    var attach1 = Attachments.attachments

    Wallservice.add(Post(0, 12, 22, 32, 81221, attach1))
    Wallservice.add(Post(0, 11, 65, 232, 91221, null))
    Attachments.attachAdd(LinkAttachment("link", Link(3, 3, 3, 3)))
    attach1 = Attachments.attachments
    Wallservice.update(Post(1, 16, 123, 3435, 101221, attach1))
    Wallservice.createComment(Comment(55, 12, 161221, "Привет!"))
    println(Wallservice.posts.joinToString())
    println(Wallservice.comments.joinToString())

}

object Wallservice {
    var posts: Array<Post> = emptyArray()
        private set
    var comments = emptyArray<Comment>()
        private set

    fun add(post: Post): Post {
        posts += post
        val notEmpty = posts.last()
        notEmpty.id = posts.size.toLong()
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var postUpdated = false
        for (i in posts.indices) {
            when {
                posts[i].id != post.id -> {
                }
                else -> {
                    posts[i].id = post.id
                    posts[i].fromId = post.fromId
                    posts[i].createdBy = post.createdBy
                    posts[i].attachment = post.attachment
                    postUpdated = true

                }
            }
        }
        return postUpdated
    }

    fun createComment(comment: Comment) {
        for (i in posts.indices) {
            when {
                posts[i].id == comment.postId -> comments += comment
            }
        }
        if (comments.isEmpty()) throw PostNotFoundException("Пост с id ${comment.postId} не существует!")
    }
}

object Attachments {
    var attachments: Array<Attachment> = emptyArray()
        private set

    fun attachAdd(attachment: Attachment): Attachment {
        attachments += attachment
        return attachments.last()
    }

}