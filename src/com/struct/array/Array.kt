package com.struct.array

/**
 * 可变数组
 */
class Array(private var size: Int) {
    private var nums: IntArray = IntArray(size)
    private var count = 0


    fun add(data: Int) {
        if (count == nums.size) {
            val newArray = IntArray(count * 2)
            nums.forEachIndexed { index, i ->
                newArray[index] = i
            }


            nums = newArray
        }
        nums[count++] = data;
    }

    fun remove(index: Int) {
        if (index < 0 || index > count) {
            throw ArrayIndexOutOfBoundsException()
        }

        (index until count).forEach { i ->
            nums[i] = nums[i + 1]
        }
        count--
    }

    fun print() {
        (0 until count).forEach { i ->
            print(nums[i])
        }
    }
}