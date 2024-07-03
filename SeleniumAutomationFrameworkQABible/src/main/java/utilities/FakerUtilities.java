package utilities;

import com.github.javafaker.Faker;

public class FakerUtilities 
{
    
  Faker faker = new Faker();  
	public String getFakeFirstName() {

		Faker faker = new Faker();  

		String firstName = faker.name().firstName();
		return firstName;

	}
	public String getFakeSecondName() {

		Faker faker = new Faker();
 
		String lastName = faker.name().lastName(); 
		return lastName;
	}
		
		public String getFakeCityName() {
			Faker faker = new Faker();
			
			String city = faker.address().city();
			return city;
		}
		
		public String getFakeEmailId()
		{   
			Faker faker = new Faker();
            String mail=faker.internet().emailAddress();
            return mail;

		}

	}


