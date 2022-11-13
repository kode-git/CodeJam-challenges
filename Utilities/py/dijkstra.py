'''''''''''
dijkstra(G, s) -> int[], int[]:
    for each v in V:
        dist[v] = inf
        prev[v] = UNDEFINED
        add v to Q
    dist[s] = 0

    while Q is not empty:
        u <- u in Q with min dist[u]
        remove u in Q

        for each v in v.adj and v in Q:
            alt <- dist[u] + w(u,v)
            if alt < dist[v]:
                dist[v] = alt
                prev[v] = u

    return dist[], prev[]

'''''''''''

