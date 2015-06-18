package Modularity;

public class unsigned {

	private int[] mVexs;
	private int[][] mMatrix; // �ڽӾ���

	public unsigned(int[] vexs, int[][] edges) {

		// ��ʼ��"������"��"����"
		int vlen = vexs.length;
		int elen = edges.length;

		// ��ʼ��"����"
		mVexs = new int[vlen];
		for (int i = 0; i < vlen; i++)
			mVexs[i] = vexs[i];

		// ��ʼ��"��"
		mMatrix = new int[vlen][vlen];
		for (int i = 0; i < elen; i++) {
			// ��ȡ�ߵ���ʼ����ͽ�������

			int p1 = edges[i][0];
			int p2 = edges[i][1];
			// System.out.print(p1);
			// System.out.print(p2);

			mMatrix[p1][p2] = edges[i][2];
			mMatrix[p2][p1] = edges[i][2];
		}
	}

	/*
	 * ��ӡ�������ͼ
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
	 * ����k
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
	 * ����ģ���
	 */
	public void cal_Q(int[][] list) {
		int A = 0;
		int k = 0;
		int M = 0;

		// ��ӡList
		System.out.printf("List:\n");
		for (int i = 0; i < list.length; i++) {
			System.out.printf("C%d = ", i + 1);
			for (int j = 0; j < list[i].length; j++)
				System.out.printf("%d ", list[i][j]);
			System.out.printf("\n");
		}

		// ���� M , M=2m
		for (int i = 0; i < mVexs.length; i++) {
			for (int j = 0; j < mVexs.length; j++) {
				if (mMatrix[i][j] == 1)
					M++;
			}
		}

		// ��ʼ��"���Ź�ϵ����"
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

		System.out.printf("������ = %d\n", mVexs.length);
		System.out.printf("���� = %d\n", M / 2);
		System.out.printf("ģ���Q = %f\n", q);
	}

}
