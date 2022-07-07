import React, { useEffect, useRef } from "react";
import Chart from "chart.js/auto";
import "./UiChart.styles.scss";


interface Props {
    chartData: any[];
}
const UiChart: React.FC<Props> = (props: Props) => {
    const { chartData } = props;


    const randomColor = () => {
        let color = '#ccc';
        color = '#' + Math.floor(Math.random() * 16777215).toString();
        if (color.length !== 7) {
            color = randomColor();
        }
        return color;
    }

    const pushColor = () => {
        const color: string[] = [];
        chartData.forEach(() => {
            color.push(randomColor());
        });
        return color;
    }

    const formatData = (data: number[]): any => ({
        labels: ["a", "b", "c", "d", "e", "f", "g", "h"],
        datasets: [{
            data: data,
            backgroundColor: pushColor(),
        }]
    });

    // use a ref to store the chart instance since it it mutable
    const chartRef = useRef<Chart | null>(null);

    const option = () => {
        let delayed: boolean;
        let data: any;
        props.chartData?.map((item: any) => {
            data = {
                animation: {
                    onComplete: () => {
                        delayed = true;
                    },
                    delay: (context: any) => {
                        let delay = 0;
                        if (context.type === 'data' && context.mode === 'default' && !delayed) {
                            delay = context.dataIndex * 300 + context.datasetIndex * 100;
                        }
                        return delay;
                    },
                },
                title: {
                    position: 'top',
                    display: true,
                },
                legend: {
                    position: item.position,
                    display: item.display,
                    labels: {
                        usePointStyle: item.usePointStyle,
                    },
                },
            };
        });
        return data;
    }

    const config: any = {
        // type: "radar",
        // data: formatData(chartData),
        // options: { responsive: true }
        type: "polarArea",
        data: formatData(chartData),
        options: {
            responsive: true,
            plugins: option(),
            interaction: {
                intersect: false,
            },
            radius: 0,
            scales: {
                x: {
                    stacked: false,
                    display: false,
                    title: {
                        display: true
                    }
                },
                y: {
                    stacked: false,
                    display: false,
                    title: {
                        display: true,
                        // text: 'Value'
                    },
                    // suggestedMin: -10,
                    // suggestedMax: 200
                }
            }
        },
    }





    // callback creates the chart on the canvas element
    const canvasCallback = (canvas: HTMLCanvasElement | null) => {
        if (!canvas) return;
        const ctx = canvas.getContext("2d");
        if (ctx) {
            chartRef.current = new Chart(ctx, config);
        }
    };
    useEffect(() => {
        // must verify that the chart exists
        if (chartRef.current) {
            chartRef.current.data = formatData(chartData);
            chartRef.current.update();
        }
        // cleanup function - I had to remove this as it was causing errors
        // return () => {
        //     chartRef.current?.destroy();
        // };
    }, [chartData]);

    return (
        <div className="chart">
            <canvas ref={canvasCallback}></canvas>
        </div>
    )
};

export default UiChart;