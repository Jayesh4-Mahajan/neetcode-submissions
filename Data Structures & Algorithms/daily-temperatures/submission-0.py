class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        
        # Brute Force
        res = [0] * len(temperatures)
        for i in range(len(temperatures) - 1):
            day = 0
            for j in range(i+1, len(temperatures)):
                day += 1
                if temperatures[j] > temperatures[i]:
                    res[i] = day
                    break

        return res