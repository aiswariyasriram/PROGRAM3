FROM openjdk:17-jdk-slim

# Step 2: Set the working directory in the container
WORKDIR /app
RUN apt-get update && apt-get install -y x11-apps
# Step 3: Copy the Java 17 application files into the container
COPY target/*.jar /app/*.jar
EXPOSE 8080
RUN apt-get update && apt-get install -y \
    libxtst6 \
    libxrender1 \
    libxi6 \
    libfreetype6 \
&& rm -rf /var/lib/apt/lists/*
 
# Set the DISPLAY environment variable
ENV DISPLAY=${DISPLAY}
 
CMD [ "java", "-cp",  "*.jar",  "org.example.BMICalculator"]

 
#NTRYPOINT ["java", "-cp" , "*.jar", "org.example.BMICalculator"]
