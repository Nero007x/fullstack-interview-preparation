class Solution:
    def mostProfitablePath(self, edges: List[List[int]], bob: int, amount: List[int]) -> int:
        adj = defaultdict(list)
        for v1, v2 in edges:
            adj[v1].append(v2)
            adj[v2].append(v1)

        #bods bfs
        bobTimes = {}

        def dfs(src, prev, time):
            if src ==0:
                bobTimes[src] = time
                return True
            
            for nei in adj[src]:
                if nei == prev:
                    continue
                if dfs(nei, src, time+1):
                    bobTimes[src] = time
                    return True
            return False
        dfs(bob, -1, 0)

        #alice bfs

        q = deque([(0, 0, -1, amount[0])])
        res = float("-inf")
        while q:
            node, time, prev, profit = q.popleft()

            for nei in adj[node]:
                if nei == prev:
                    continue
                neiProfit = amount[nei]
                neiTime = time+1
                if nei in bobTimes:
                    if neiTime > bobTimes[nei]:
                         neiProfit = 0
                    if neiTime == bobTimes[nei]:
                        neiProfit = neiProfit//2
                q.append((nei, neiTime, node, profit+neiProfit))
                if len(adj[nei]) == 1:
                    res = max(res, profit+neiProfit)

        return res