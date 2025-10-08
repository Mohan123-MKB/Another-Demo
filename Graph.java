//1. BFS
class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code gg
       ArrayList<Integer> bf = new ArrayList<>();
        boolean vis[] = new boolean[adj.size()]; // Corrected: need to initialize with size
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bf.add(node);

            for (Integer it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bf;
    }
}
//2. DFS
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean vis[]=new boolean[adj.size()];
        ArrayList<Integer> res=new ArrayList<>();
        dfs(0,adj,vis,res);
        return res;
    }
    private static void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean vis[],ArrayList<Integer> res){
       //marking current node as visited
       vis[node]=true;
       res.add(node);
       
       //getting neighbour nodes
       for(Integer it:adj.get(node)){
           if(vis[it]==false){
               dfs(it,adj,vis,res);
           }
       }
    }
}
//3. Number of Provinces
class Solution {
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        //main logic for number of provinces
        int[] vis = new int[V];
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                cnt++;
                dfs(i, adj, vis, V);
            }
        }
        return cnt;
    }
    
    //adj matrix direct call
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int V) {
        vis[node] = 1;
        for (int j = 0; j < V; j++) {
            if (adj.get(node).get(j) == 1 && vis[j] == 0) { //adj.get(node).get(j) == 1 is neighbours
                dfs(j, adj, vis, V);
            }
        }
    }
}
//4. Number of Islands
class Pair {
    int row, col;
    Pair(int r, int c) {
        row = r;
        col = c;
    }
}

class Solution {
    private void bfs(int r, int c, int[][] vis, char[][] grid) {
        vis[r][c] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));

        int n = grid.length;
        int m = grid[0].length;

        // ✅ 8 possible directions
        int[] dRow = {-1,-1,-1, 0, 0, 1, 1, 1};
        int[] dCol = {-1, 0, 1,-1, 1,-1, 0, 1};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;

            for (int i = 0; i < 8; i++) {
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                    grid[newRow][newCol] == 'L' && vis[newRow][newCol] == 0) {
                    
                    vis[newRow][newCol] = 1;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
    }

    public int countIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (vis[row][col] == 0 && grid[row][col] == 'L') {
                    count++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return count;
    }
}
