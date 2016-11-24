import javax.swing.JPanel;

public class Move extends JPanel {
	
		private MahJongGUI mGUI;
		private int tileOne;
		private int tileTwo;
		

		public Move(MahJongGUI mGUI, int tileOne, int tileTwo) {
			this.setmGUI(mGUI);
			this.setTileOne(tileOne);
			this.setTileTwo(tileTwo);
		}
		

		public int getTileTwo() {
			return tileTwo;
		}
		
		public void setTileTwo(int tileTwo) {
			this.tileTwo = tileTwo;
		}


		public int getTileOne() {
			return tileOne;
		}


		public void setTileOne(int tileOne) {
			this.tileOne = tileOne;
		}


		public MahJongGUI getmGUI() {
			return mGUI;
		}


		public void setmGUI(MahJongGUI mGUI) {
			this.mGUI = mGUI;
		}

		
}
