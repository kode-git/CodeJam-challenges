'''''''''''

dfs_single_visit(adj_list, v, visited, stack):
    for u in adj_list[v]:
        if u not in visited:
            visited[u] = v
            dfs_single_visit(adj_list, u, visited, stack)
    stack.append(v)

dfs(G, stack):
    # init parent set and stack
    parent = {}
    stack = []

    for v in list(G.adj.keys()):
        if v not in parent:
            parent[v] = None
            dfs_visit(G, v, parent, stack)
    return stack

    
kosaraju(G):    
    # gettingvertices based on their finishing time in decreasing order
    stack = dfs(G, [])

    # reverse edges of the graph G
    rev_adj = {}

    for v in G.adj.keys():
        rev_adj[v] = {}
    
    # setting adiacent nodes for each node
    for v in G.adj.keys():
        for u in g.adj[v]:
            rev_adj[u][v] = True

    # Traverse graph by popping vertices out from the stack
    visited = {} # set of visited nodes
    components = [] # strongly components
    i = 0

    while not stack.isEmpty():
        v = stack.pop()
        # skip iteration if v is already visited
        if v in visited:
            continued
        else:
            components.append([])
            if v not in visited:
                visited[v] = True
                dfs_single_viist(rev_adj, v, visited, components[i])
            components.append([])
            i +=1

    return components


'''''''''''