class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # Step 1: Build adjacency list (preMap) to represent course prerequisites
        premap = collections.defaultdict(list)
        for crs, pre in prerequisites:
            premap[crs].append(pre)  # Course 'crs' depends on 'pre'
    
        # Set to track visited nodes in the current path for cycle detection
        visit = set()

        # Step 2: Depth-First Search (DFS) function to detect cycles
        def dfs(crs):
            # If course is already in the current path, a cycle is detected
            if crs in visit:
                return False
            
            # If course has no prerequisites, it can be completed
            if premap[crs] == []:
                return True

            # Mark the current course as visited in this path
            visit.add(crs)
            for pre in premap[crs]:
                # Recursively visit prerequisites
                if not dfs(pre):
                    return False  # Cycle detected in the prerequisite chain
            
            # Remove the course from the current path and mark it as processed
            visit.remove(crs)
            premap[crs] = []  # Clear prerequisites to avoid redundant checks
            return True

        # Step 3: Iterate through each course to ensure all can be finished
        for c in range(numCourses):
            if not dfs(c):
                return False  # Return False if a cycle is detected

        return True  # All courses can be finished
