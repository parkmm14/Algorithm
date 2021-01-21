### 7469 K번째 수

https://www.acmicpc.net/problem/7469

시간 초과를 조심해야 하는 문제..

``` java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int[][] data;
  static int[][] temp;

  public static void main(String[] args) throws Exception {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer t = new StringTokenizer(sc.readLine());
    int n = Integer.parseInt(t.nextToken());
    int k = Integer.parseInt(t.nextToken());

    data = new int[n][2];
    temp = new int[n][2];

    t = new StringTokenizer(sc.readLine());
    for (int i = 1; i <= n; i++) {
      data[i - 1][0] = Integer.parseInt(t.nextToken());
      data[i - 1][1] = i;
    }

    mergeSort(0, n - 1);

    while (k > 0) {
      t = new StringTokenizer(sc.readLine());
      int x = Integer.parseInt(t.nextToken());
      int y = Integer.parseInt(t.nextToken());
      int z = Integer.parseInt(t.nextToken());
      System.out.println(q(x, y, z));
      k--;
    }
    sc.close();
  }

  private static int q(int i, int j, int k) {
    int c = 0;
    for (int x = 0; x < data.length; x++) {
      if (data[x][1] >= i && data[x][1] <= j) {
        c++;
        if (c == k) {
          return (data[x][0]);
        }
      }
    }
    return 0;
  }

  private static void mergeSort(int low, int high) {
    if (low < high) {
      int mid = low + (high - low) / 2;
      mergeSort(low, mid);
      mergeSort(mid + 1, high);
      merge(low, mid, high);
    }
  }

  private static void merge(int low, int mid, int high) {
    for (int i = low; i <= high; i++) {
      temp[i][0] = data[i][0];
      temp[i][1] = data[i][1];
    }

    int i = low;
    int j = mid + 1;
    int k = low;

    while (i <= mid && j <= high) {
      if (temp[i][0] < temp[j][0]) {
        data[k][0] = temp[i][0];
        data[k][1] = temp[i][1];
        i++;
      } else {
        data[k][0] = temp[j][0];
        data[k][1] = temp[j][1];
        j++;
      }
      k++;
    }

    while (i <= mid) {
      data[k][0] = temp[i][0];
      data[k][1] = temp[i][1];
      i++;
      k++;
    }
  }

}
```

