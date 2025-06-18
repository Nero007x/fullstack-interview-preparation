class Solution:
    def maximumDetonation(self, bombs: List[List[int]]) -> int:
        def bfs(start, graph):
            q= deque([start])
            visited = set()
            visited.add(start)
            count = 0
            while q:
                curr = q.popleft()
                count+=1
                for nei in graph[curr]:
                    if nei not in visited:
                        q.append(nei)
                        visited.add(nei)
            return count

        adjList = defaultdict(list)
        maxB = 0
        for i in range(len(bombs)):
            x1, y1, r1 = bombs[i]
            for j in range(len(bombs)):
                if i==j:
                    continue
                x2, y2, _ = bombs[j]
                dx= x2-x1
                dy= y2-y1
                if dx*dx+dy*dy<= r1*r1:
                    adjList[i].append(j)
        for i in range(len(bombs)):
            maxB = max(bfs(i, adjList), maxB)
        return maxB

