package Modularity;

public class signed {

	private int[] mVexs;
	private int[][] mMatrix; // 邻接矩阵

	public signed(int[] vexs, int[][] edges) {

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

			int p1 = edges[i][0];
			int p2 = edges[i][1];

			mMatrix[p1][p2] = edges[i][2];
			mMatrix[p2][p1] = edges[i][2];

		}
	}

	/*
	 * 打印矩阵队列图
	 */
	public void print() {
		System.out.printf("signed Martix Graph:\n");
		for (int i = 0; i < mVexs.length; i++) {
			for (int j = 0; j < mVexs.length; j++)
				System.out.printf("%3d", mMatrix[i][j]);
			System.out.printf("\n");
		}
	}

	/*
	 * 计算k1 (正强度)
	 */
	public int cal_k1(int i) {
		int k1 = 0;
		for (int j = 0; j < mVexs.length; j++) {
			if (mMatrix[i][j] == 1)
				k1++;
		}
		return k1;
	}

	/*
	 * 计算k2 (负强度)
	 */
	public int cal_k2(int i) {
		int k2 = 0;
		for (int j = 0; j < mVexs.length; j++) {
			if (mMatrix[i][j] == -1)
				k2++;
		}
		return k2;
	}

	/*
	 * 计算模块度
	 */
	public void cal_Q(int[][] list) {
		int A = 0;
		int kz = 0, kf = 0;
		int M = 0, M1 = 0, M2 = 0;
		int F = 0, N = 0, P = 0;

		// 打印List
		System.out.printf("List:\n");
		for (int i = 0; i < list.length; i++) {
			System.out.printf("C%d = ", i + 1);
			for (int j = 0; j < list[i].length; j++)
				System.out.printf("%d ", list[i][j]);
			System.out.printf("\n");
		}

		// 计算 M , 所有正边和负边的和
		for (int i = 0; i < mVexs.length; i++) {
			for (int j = 0; j < mVexs.length; j++) {
				if (mMatrix[i][j] == 1) {
					M1++;
				} else if (mMatrix[i][j] == -1) {
					M2++;
				}
				M = M1 + M2;
			}
		}

		// 初始化"社团数组关系" i,j不在一个数组中
		for (int i1 = 0; i1 < list.length; i1++) {
			for (int i2 = i1 + 1; i2 < list.length; i2++) {
				for (int j1 = 0; j1 < list[i1].length; j1++) {
					for (int j2 = 0; j2 < list[i2].length; j2++) {

						int p = list[i1][j1] - 1;
						int q = list[i2][j2] - 1;

						if (mMatrix[p][q] == 1) {
							P++;
						}

					}
				}
			}
		}

		// 初始化"社团关系数组" i,j在一个数组中
		for (int i = 0; i < list.length; i++) {
			for (int j1 = 0; j1 < list[i].length; j1++) {
				for (int j2 = j1 + 1; j2 < list[i].length; j2++) {

					int p = list[i][j1] - 1;
					int q = list[i][j2] - 1;

					if (mMatrix[p][q] == 1) {
						A = A + 2;
					} else if (mMatrix[p][q] == -1) {
						A = A - 2;
						N++;
					}

					int k1 = cal_k1(p); // 正强度
					int k2 = cal_k2(p); // 负强度

					int k3 = cal_k1(q); // 正强度
					int k4 = cal_k2(q); // 负强度

					kz += k1 * k3; // 正强度相乘
					kf += k2 * k4; // 负强度相乘

				}
			}
		}

		kz = 2 * kz;
		kf = 2 * kf;

		System.out.printf("顶点数 = %d\n", mVexs.length);
		System.out.printf("边数 = %d\n", M / 2);
		System.out.printf("正边数 = %d\n", M1 / 2);
		System.out.printf("负边数 = %d\n", M2 / 2);

		F = N + P;

		float q1 = ((float) 1 / M) * A;
		float q2 = ((float) 1 / (M * M1)) * kz;
		float q3 = ((float) 1 / (M * M2)) * kf;
		float q = q1 - q2 + q3;

		System.out.printf("模块度Q = %f\n", q);
		System.out.printf("挫败值F = %d\n", F);
	}

}
