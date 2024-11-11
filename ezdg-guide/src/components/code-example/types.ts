export type CodeLanguage = 'java' | 'javascript' | 'typescript' | 'xml' | 'bash' | 'python' | 'markdown' | 'json';

export interface CodeExample {
  title: string;
  description?: string;
  code: string;
  language: CodeLanguage
}

export interface CodeSectionProps {
  installations: CodeExample[];
  className?: string;
}