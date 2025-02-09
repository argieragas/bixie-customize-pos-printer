export interface BixiePOSPrinterPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  SamplePrinter(options: {name: string}): Promise<{value: string}>;
  Image(options: {image: ImageData}): Promise<{value: string}>;
}
