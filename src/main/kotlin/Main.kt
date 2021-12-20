fun main(args: Array<String>) {
    Attachments.attachAdd(VideoAttachment("video", Video(21, 12, 1, 12)))
    Attachments.attachAdd(AudioAttachment("audio", Audio(1, 2, 3, 4)))
    Attachments.attachAdd(LinkAttachment("link", Link(2, 2, 2, 2)))
    var attach1 = Attachments.attachments
    var posts = Wallservice()
    posts.addPost(Post(0, 12, 22, 32, 81221, attach1))
    posts.addPost(Post(0, 11, 65, 232, 91221, null))
    Attachments.attachAdd(LinkAttachment("link", Link(1, 3, 3, 3)))
    attach1 = Attachments.attachments
    posts.updatePost(Post(1, 16, 123, 3435, 101221, attach1))
    posts.createComment(Comment(3, 12, 161221, "Привет!"))
    println(posts.posts.joinToString())
    println(posts.comments.joinToString())
}

class Wallservice {
    var posts: Array<Post> = emptyArray()
        private set
    var comments: Array<Comment> = emptyArray()
        private set

    fun addPost(post: Post): Post {
        posts += post
        val notEmpty = posts.last()
        notEmpty.id = posts.size.toLong()
        return posts.last()
    }

    fun updatePost(post: Post): Boolean {
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
        var flag = false
        for (i in posts.indices) {
            if (posts[i].id == comment.postId) {
                comments += comment
                flag = true
            }
        }
        if (flag == false) throw PostNotFoundException("Пост с id ${comment.postId} не существует!")
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