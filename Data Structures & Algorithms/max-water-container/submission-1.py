class Solution:
    def maxArea(self, heights: List[int]) -> int:
        # Brute force O(n^2)
        # max_area = 0
        # i = 0
        # j = len(heights)
        # for i in range(len(heights) - 1):
        #     for j in range(i+1, len(heights)):
        #         height = min(heights[i], heights[j])
        #         width = j - i
        #         area = height * width
        #         max_area = max(max_area, area)

        # return max_area

        # Optimal Solution O(n)
        # Two pointer approach
        res = 0
        i = 0
        j = len(heights) - 1
        while i < j:
            area = (j - i) * min(heights[i], heights[j])
            res = max(area, res)
            if heights[i] <=  heights[j]:
                i += 1
            elif heights[i] > heights[j]:
                j -= 1
        return res
