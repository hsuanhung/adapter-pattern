** Client */
public class Main {
    public static void main(String[] args) {
        String content = "...";
        Exporter exportUtil = new ExportUtil();
        exportUtil.export(content); // export to somewhere
        System.out.println("===========================");
        Exporter fileWriterExporter = new WriterAdapter(new FileWriter("file.txt"));
        fileWriterExporter.export(content); // export to file.txt
    }
}

/** Target */
interface Exporter {
    void export(String content);
}

/** Target concrete class */
class ExportUtil implements Exporter {
    @Override
    public void export(String content) {
        System.out.println("export content to somewhere");
    }
    
}

/** Adaptee */
interface Writer {
    void write(byte[] bytes);
}

/** Adaptee concrete class*/
class FileWriter implements Writer {
    private String fileName;
        public FileWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(byte[] bytes) {
        System.out.println("write to " + fileName);
    }
}

/** Adapter */
class WriterAdapter implements Exporter {
    private Writer writer;
    public WriterAdapter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void export(String content) {
        writer.write(content.getBytes());
    }
}

