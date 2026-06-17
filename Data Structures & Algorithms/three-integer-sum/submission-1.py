class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # Brute force
        # result = set()

        # for i in range(len(nums)-2):
        #     for j in range(i + 1, len(nums) - 1):
        #         for k in range(j + 1, len(nums)):
        #             if nums[i] + nums[j] + nums[k] == 0:
        #                 result.add((nums[i], nums[j], nums[k]))
        # return [list(res) for res in list(result)]

        result = set()
        nums = sorted(nums) # O(nlogn)
        for i in range(len(nums) - 2):
            l = i + 1
            r = len(nums) - 1
            while l < r:
                if nums[i] + nums[l] + nums[r] == 0:
                    result.add((nums[i], nums[l], nums[r]))
                    r -= 1
                elif nums[i] + nums[l] + nums[r] > 0:
                    r -= 1
                elif nums[i] + nums[l] + nums[r] < 0:
                    l += 1
        return [list(res) for res in list(result)]
