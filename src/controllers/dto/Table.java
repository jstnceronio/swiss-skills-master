package controllers.dto;

public class Table {
        private int number;
        private int seats;

        public int getnumber()
        {
            return this.number;
        }
        public void setnumber(int value)
        {
            this.number = value;
        }

        public int getseats()
        {
            return this.seats;
        }
        public void setseats(int value)
        {
            this.seats = value;
        }

        public Table(int number_,int seats_)
        {
            this.number = number_;
            this.seats = seats_;
        }
}
