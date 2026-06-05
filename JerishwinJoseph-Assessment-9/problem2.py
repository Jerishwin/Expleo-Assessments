class person():

    def __init__(self,name,age,email):
        self.name=name
        self.age=age
        self.email=email

    def display_info(self):
        print("Name: ",self.name)
        print("Age: ",self.age)

class Trainee(person):
    def __init__(self,name,age,email,batch_id,marks,num_projects,num_publications):
        super().__init__(name,age,email)
        self.batch_id=batch_id
        self.marks=marks
        self.avg=(sum(self.marks))/5
        self.num_projects=num_projects
        self.num_publications=num_publications
    
    def display_info(self):
        super().display_info()
        print("Batch ID: ",self.batch_id)
        print("Marks: ",self.marks)
        print("Avg: ",self.avg)
        print("Projects: ",self.num_projects," | Publications: ",self.num_publications)

class SDETTrainee(Trainee):
    def __init__(self, name, age, email, batch_id, marks, num_projects, num_publications,tool_proficiency):
        super().__init__(name, age, email, batch_id, marks, num_projects, num_publications)
        self.tool_proficiency=tool_proficiency
    
    def compute_aggregate(self):
        return ((self.avg) + (self.num_projects*5) +(self.num_publications*3))
    
    def display_info(self):
        super().display_info()
        print("Tool: ",self.tool_proficiency)
        print("Aggregate Score: ",self.compute_aggregate())

joe = SDETTrainee("Joe",23,"joe@mail.com","Ba01",[50,67,89,56,78],3,2,"Selenium")

Rob = SDETTrainee("Rob",25,"rob@hotmail.com","B001",[70,96,78,69,67],3,4,"Selenium")

if joe.compute_aggregate() > Rob.compute_aggregate():
    joe.display_info()
else:
    Rob.display_info()