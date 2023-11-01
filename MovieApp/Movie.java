class Movie implements Comparable
{
	private String title ;
	private double duration ;
	private int year ;

	Movie(String title , double duration , int year)
	{
		this.title = title ;
		this.duration = duration ;
		this.year = year ;
	}

	public void setTitle(String title)
	{
		this.title = title ;
	}

	public void setDuration(double duration)
	{
		this.duration = duration ;
	}

	public void setYear(int year)
	{
		this.year = year ;
	}

	public String getTitle()
	{
		return title ;
	}

	public double getDuration()
	{
		return duration ;
	}

	public int getYear()
	{
		return year ;
	}

	@Override
		public String toString()
		{
			return "Title: "+title+", Duration: "+duration+",  Year: "+year ;
		}

	@Override
		public boolean equals(Object o)
		{
			Movie tempMovie = (Movie) o ;

			if(this.title == tempMovie.title)
			{
				return true ;
			}
			return false ;
		}

	@Override
		public int hashCode()
		{
			return title.hashCode() ;
		}

	@Override
		public int compareTo(Object o)
		{
			Movie tempMovie = (Movie) o ;

			if(this.title.charAt(0) > tempMovie.title.charAt(0))
			{
				return 1 ;
			}
			if(this.title.charAt(0) < tempMovie.title.charAt(0))
			{
				return -1 ;
			}

			return 0 ;
		}
}