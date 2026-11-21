public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("Root");

        File file1 = new File("document.pdf", 10);
        File file2 = new File("image.jpg", 5);
        File file3 = new File("notes.txt", 2);

        Directory subDirectory = new Directory("Projects");

        subDirectory.add(new File("project1.pdf", 20));
        subDirectory.add(new File("project2.txt", 3));
        subDirectory.add(new File("presentation.pdf", 15));

        root.add(file1);
        root.add(file2);
        root.add(file3);
        root.add(subDirectory);

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();

        root.accept(sizeVisitor);

        System.out.println("Total file size: " + sizeVisitor.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(".pdf");

        root.accept(searchVisitor);
        System.out.println("\nPDF files found:");

        for (File file : searchVisitor.getFoundFiles()) {
            System.out.println("- " + file.getName() + " (" + file.getSize() + " MB)");
        }
    }
}