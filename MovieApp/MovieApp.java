import java.util.HashSet ;
import java.util.Scanner ;

class MovieApp
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in) ;

		Movie movie1 = new Movie("PHIR HERA PHERI",2.75,2010) ;
		Movie movie2 = new Movie("CHUP CHUP KE",2.50,2008) ;
		Movie movie3 = new Movie("DHOL",2.80,2009) ;
		Movie movie4 = new Movie("3 IDIOTS",2.50,2011) ;
		Movie movie5 = new Movie("JAB WE MET",2.20,2009) ;
		Movie movie6 = new Movie("BHULBHULAIYAA",2.80,2010) ;
		Movie movie7 = new Movie("YEH JAWANI HAI DEEWANI",2.40,2015) ;
		Movie movie8 = new Movie("DIL BECHARA",2.30,2020) ;
		Movie movie9 = new Movie("KARTHIKEYA-2",2.20,2022) ;
		Movie movie10 = new Movie("GANGS OF WASSEYPUR",2.30,2012) ;

		//1st task**********************************************************************

		System.out.println("\n\n\t\t****** 1st Task - To Add Movies in Set ******") ;

		HashSet<Movie> movieSet = new HashSet<Movie>() ;
		movieSet.add(movie1) ;
		movieSet.add(movie2) ;
		movieSet.add(movie3) ;
		movieSet.add(movie4) ;
		movieSet.add(movie5) ;
		movieSet.add(movie6) ;
		movieSet.add(movie7) ;
		movieSet.add(movie8) ;
		movieSet.add(movie9) ;
		movieSet.add(movie10) ;

		//2nd task**********************************************************************

		System.out.println("\n\n\t\t****** 2nd Task - To Print Titles of Movies ******");

		for(Movie movie : movieSet)
		{
			System.out.println(movie.getTitle()) ;
		}

		//3rd task**********************************************************************

		System.out.println("\n\n\t\t****** 3rd Task - To Print Details of All Movies ******");

		for(Movie movie : movieSet)
		{
			System.out.println(movie) ;
		}

		//4th task**********************************************************************

		System.out.println("\n\n\t\t****** 4th Task - To Check Whether the Given Movie Present In Set or Not ******") ;

		System.out.println("Check Any Movie: ") ;

		String movieName = sc.nextLine() ;
		boolean flag = false ;

		for(Movie movie : movieSet)
		{
			if(movie.getTitle().equals(movieName))
			{
				flag = true ;
			}
		}

		if(flag)
		{
			System.out.println("The Entered Movie Present In Collection") ;
		}
		else{
			System.out.println("Sorry, the entered movie not present in collection") ;
		}

		//5th task*********************************************************************

		System.out.println("\n\n\t\t****** 5th Task - To Count The Number of Movies in the Given Year ******") ;

		System.out.println("Enter Any Year: ") ;
		int userYear = sc.nextInt() ;
		int count = 0 ;

		for(Movie movie : movieSet)
		{
			if(movie.getYear() == userYear)
			{
				count++ ;
			}
		}

		System.out.println("Movies From The Given Year: "+count) ;

		//6th task********************************************************************

		System.out.println("\n\n\t\t****** 6th Task - To List The Movies From Given Range of Years ******") ;

		System.out.println("Enter The Range of Years: ") ;
		int userYear1 = sc.nextInt() ;
		System.out.println("to") ;
		int userYear2 = sc.nextInt() ;

		for(Movie movie : movieSet)
		{
			if(movie.getYear() >= userYear1 && movie.getYear() <= userYear2)
			{
				System.out.println(movie) ;
			}
		}

		//*****************************************************************************
	}
}