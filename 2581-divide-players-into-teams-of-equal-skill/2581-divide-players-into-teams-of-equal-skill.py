class Solution:
    def dividePlayers(self, skill: list[int]) -> int:
        skill.sort()
        target_skill = skill[0] + skill[-1]
        chemistry_sum = 0
        
        i, j = 0, len(skill) - 1
        while i < j:
            if skill[i] + skill[j] != target_skill:
                return -1
            chemistry_sum += skill[i] * skill[j]
            i += 1
            j -= 1
        
        return chemistry_sum        