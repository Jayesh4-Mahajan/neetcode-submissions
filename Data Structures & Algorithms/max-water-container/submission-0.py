class Solution:
    def maxArea(self, heights: List[int]) -> int:
        max_area = 0
        i = 0
        j = len(heights)
        for i in range(len(heights) - 1):
            for j in range(i+1, len(heights)):
                height = min(heights[i], heights[j])
                width = j - i
                area = height * width
                max_area = max(max_area, area)

        return max_area