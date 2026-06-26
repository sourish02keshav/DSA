class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i < connections.size();i++)
        {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,1,vis,tin,low,bridges,adj);
        return bridges;
    }
    public void dfs(int node,int parent,int timer,int[] vis,int[] tin,int[] low,
    List<List<Integer>> bridges,ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        for(int neigh : adj.get(node))
        {
            if(neigh == parent)
            {
                continue;
            }
            if(vis[neigh] == 0)
            {
                dfs(neigh,node,timer,vis,tin,low,bridges,adj);
                low[node] = Math.min(low[node],low[neigh]);
                if(low[neigh] > tin[node])
                {
                    bridges.add(Arrays.asList(node,neigh));
                }
            }
            else
            {
                low[node] = Math.min(low[node],low[neigh]);
            }
        }
    }
}