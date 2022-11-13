

'''''''''''
dfs(G, v) -> T:
    for v in V:
        v.mark = False
    
    v.mark = True
    for all x in v.adj:
        if x.mark == False
            x.parent = v
            return dfs(G,x)
    return v
'''''''''''