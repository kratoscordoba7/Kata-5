package View;
import Model.Histogram;
import java.awt.Dimension;
import java.time.DayOfWeek;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class histogramDisplay extends ApplicationFrame{

    private final Histogram<Integer> histogram;
    
    public histogramDisplay(Histogram<Integer> histogram ,String title) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
        execute();
        createPanel();
    }
    
    private void execute(){
        this.setVisible(true);
    }
    
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart("Arrival delay", "Dominios vuelos", "N vuelos", dataset, PlotOrientation.VERTICAL, false,false, rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset  createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
                
        for (Integer key: this.histogram.keySet()){
            dataset.addValue(this.histogram.get(key), "", key);
        }
        
        return dataset;
    }
    
}
