package Modularity;

public class unsigned {

	private int[] mVexs;
	private int[][] mMatrix; // 邻接矩阵

	public unsigned(int[] vexs, int[][] edges) {

		// 初始化"顶点数"和"边数"
		int vlen = vexs.length;
		int elen = edges.length;

		// 初始化"顶点"
		mVexs = new int[vlen];
		for (int i = 0; i < vlen; i++)
			mVexs[i] = vexs[i];

		// 初始化"边"
		mMatrix = new int[vlen][vlen];
		for (int i = 0; i < elen; i++) {
			// 读取边的起始顶点和结束顶点

			int p1 = edges[i][0];
			int p2 = edges[i][1];
			// System.out.print(p1);
			// System.out.print(p2);

			mMatrix[p1][p2] = edges[i][2];
			mMatrix[p2][p1] = edges[i][2];
		}
	}

	/*
	 * 打印矩阵队列图
	 */
	public void print() {
		System.out.printf("unsigned Martix Graph:\n");
		for (int i = 0; i < mVexs.length; i++) {
			for (int j = 0; j < mVexs.length; j++)
				System.out.printf("%d ", mMatrix[i][j]);
			System.out.printf("\n");
		}
	}

	/*
	 * 计算k
	 */
	public int cal_k(int i) {
		int k1 = 0;
		for (int j = 0; j < mVexs.length; j++) {
			if (mMatrix[i][j] == 1)
				k1++;
		}
		return k1;
	}

	/*
	 * 计算模块度
	 */
	public void cal_Q(int[][] list) {
		int A = 0;
		int k = 0;
		int M = 0;

		// 打印List
		System.out.printf("List:\n");
		for (int i = 0; i < list.length; i++) {
			System.out.printf("C%d = ", i + 1);
			for (int j = 0; j < list[i].length; j++)
				System.out.printf("%d ", list[i][j]);
			System.out.printf("\n");
		}

		// 计算 M , M=2m
		for (int i = 0; i < mVexs.length; i++) {
			for (int j = 0; j < mVexs.length; j++) {
				if (mMatrix[i][j] == 1)
					M++;
			}
		}

		// 初始化"社团关系数组"
		for (int i = 0; i < list.length; i++) {
			for (int j1 = 0; j1 < list[i].length; j1++) {
				for (int j2 = j1 + 1; j2 < list[i].length; j2++) {

					int p = list[i][j1] - 1;
					int q = list[i][j2] - 1;

					if (mMatrix[p][q] == 1)
						A = A + 2;

					int k1 = cal_k(p);
					int k2 = cal_k(q);
					k += k1 * k2;
				}
			}
		}

		k = 2 * k;

		float q1 = ((float) 1 / M) * A;
		float q2 = ((float) 1 / (M * M)) * k;
		float q = q1 - q2;

		System.out.printf("顶点数 = %d\n", mVexs.length);
		System.out.printf("边数 = %d\n", M / 2);
		System.out.printf("模块度Q = %f\n", q);
	}

}
