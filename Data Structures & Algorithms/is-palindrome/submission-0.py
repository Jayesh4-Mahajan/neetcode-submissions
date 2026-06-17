class Solution:
    def isPalindrome(self, s: str) -> bool:
        left = 0
        right = len(s) - 1
        while left < right:
            if s[left] == " " or not s[left].isalnum():
                left += 1
            elif s[right] == " " or not s[right].isalnum():
                right -=1
            elif s[left].lower() == s[right].lower():
                left += 1
                right -= 1
            else:
                return False
        return True