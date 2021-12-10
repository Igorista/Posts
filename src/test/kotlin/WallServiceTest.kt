import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {
    @Test
    fun postExisting() {
        val result: Boolean
        val service = Wallservice
        val add = service.add(Post(0,111,123,12312,123123))
        val(id,_ownerId,_fromId,_createdBy,_date) = add
        when {
            id > 0 -> result = true
            else -> result = false
        }
        assertTrue(result)
    }
    @Test
    fun updateExistingTrue(){
        val service = Wallservice
        service.add(Post(0,111,123,12312,123123))
        service.add(Post(0,1,112,558,88888))
        service.add(Post(0,5551,515,879,797979))
        val update = Post(1,5551,611544,445,797979)
        val result = service.update(update)
        assertTrue(result)
    }
    @Test
    fun updateExistingFalse() {
        val service = Wallservice
        service.add(Post(0, 111, 123, 12312, 123123))
        service.add(Post(0, 1, 112, 558, 88888))
        service.add(Post(0, 5551, 515, 879, 797979))
        val update = Post(5, 1616, 611544, 445, 44444)
        val result = service.update(update)
        assertFalse(result)
    }
}