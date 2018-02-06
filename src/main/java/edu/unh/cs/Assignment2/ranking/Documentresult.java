package edu.unh.cs.Assignment2.ranking;


	//Setter getter class for ranking  from previous coding
	public class Documentresult {
		private int docId;
		private float score;
		private int rank;

		Documentresult(int id, float s) {
			this.docId = id;
			this.score = s;
			this.rank = 0;
		}

		
		public int getRank() {
			return this.rank;
		}

		public void setId(int id) {
			this.docId = id;
		}

		public void setScore(float s) {
			this.score = s;
		}

		public void setRank1(int r) {
			this.rank = r;
		}
		
		public int getId() {
			return this.docId;
		}

		public float getScore() {
			return this.score;
		}



	public void setRank(int rankCount) {
		// TODO Auto-generated method stub
		
	}


}
