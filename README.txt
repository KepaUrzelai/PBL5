In this readme, I explain where and how the threads and semaphores are used un our program.

It's just a demo.

We initialize some segment, but we just use 2 workspaces to generate products.

First of all we have the 'workstation' class, in the 'clases' package, that implements 'Runnable'. 

We initialize them in the 'ControlOrder' class, in the 'control' package, after including to the workspace the products he has
to create from the order. (We know this is not well done, and that we have to initialize the thread first and then put it waiting
to the product, we will do it in the next version).

We also have the 'vehicles' class, in the 'clases' package, that implements 'Runnable'. We initialize them and we put them 
"waiting". Once a product is ready to go in a workspace, he calls to 'ControlVehicles' class where a vehicles list is defined. We 
take the first vehicle and we notify() it, to wake it up and to take the product. Once the process is finished, the vehicle enters
in the available vehicles list again. 

¡¡We had initialized 3 vehicles but just 2 can be moving at the same time(we do this to demostrate we know how to use semaphores)!!

In the Main class we initialize a order with some products.